class Solution {
    public int shortestBridge(int[][] A) {
        int color=2;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1){
                    colorIsland(A,i,j,color++);
                    
                }
            }
        }
        
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] temp=q.poll();
            for(int[] z:dir){
                int x=temp[0]+z[0];
                int y=temp[1]+z[1];
                if(isSafe(A,x,y)&&A[x][y]==2) continue;
                if(isSafe(A,x,y)&&A[x][y]==3) return temp[2];
                if(isSafe(A,x,y)&&A[x][y]==0) {
                    A[x][y]=2;
                    q.add(new int[]{x,y,temp[2]+1});
                }
                
            }
        }
        
        return 0;
    }
    
    boolean isSafe(int[][] A,int i,int j){
        if(i>=A.length||j>=A[0].length||i<0||j<0) return false;
        return true;
    }
    
    void colorIsland(int[][] A,int i,int j,int color){
        if(i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j]!=1) return;
        A[i][j]=color;
        colorIsland(A,i+1,j,color);
        colorIsland(A,i,j+1,color);
        colorIsland(A,i-1,j,color);
        colorIsland(A,i,j-1,color);
    }
}
