class Solution {
    class Node{
        char task;
        int count=0;
        Node(char task,int count){
            this.task=task;
            this.count=count;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Queue<Node> q=new PriorityQueue<>((a,b) -> b.count-a.count);
        HashMap<Integer,Node> sleepingMap=new HashMap<>();
        HashMap<Character,Integer> map=new HashMap<>();
        //mapping the number of occurences of each task
        for(char c:tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //iterate through the map and add to the Q
        for(Map.Entry<Character,Integer> k:map.entrySet()){
            q.add(new Node(k.getKey(),k.getValue()));
        }
        int currentT=0;
        
        while(!q.isEmpty()||!sleepingMap.isEmpty()){
            if(sleepingMap.containsKey(currentT)){
                Node ele=sleepingMap.remove(currentT);
                q.add(ele);
            }
            int cooldown=currentT+n+1;
            if(!q.isEmpty()){
                Node ele2=q.poll();
                ele2.count=ele2.count-1;
                if(ele2.count>0){
                    sleepingMap.put(cooldown,ele2);
                }
            }
            currentT++;
        }
        return currentT;
        
    }
}
