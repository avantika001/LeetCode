class Solution {
    
    public int numSquares(int n) {
        if(n<=3) return n;
        int memo[]=new int[n+1];
        Arrays.fill(memo,-1);
        return calc(n,memo);
    }
    
    int calc(int n,int[] memo){
        if(n<=3) return n;
        
        if(memo[n]>-1) return memo[n];
        
        int result=n;
        
        for(int i=1;i*i<=n;i++){
            result=Math.min(result,1+calc(n-i*i,memo));
        }
        memo[n]=result;
        return memo[n];
    }
}
