class Solution {
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(!map.containsKey(i)){
                if(!dfs(graph,i,map)) return false;
            }
        }
        return true;
    }
    
    boolean dfs(int[][] graph,int root,HashMap<Integer,Integer> map){
        int rootval=0;
        if(map.containsKey(root)){
            rootval=map.get(root);
        }
        map.put(root,rootval);
        int newval=(rootval==0)?1:0;
        int[] g=graph[root];
        for(int i=0;i<g.length;i++){
            if(map.containsKey(g[i])){
                if(map.get(g[i])!=newval) return false;
            }else{
                map.put(g[i],newval);
                if(!dfs(graph,g[i],map)) return false;
            }
        }
        return true;
    }
}
