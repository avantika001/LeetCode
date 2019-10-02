class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(prices==null||n<=1) return 0;
        int sell[]=new int[n];
        int cooldown[]=new int[n];
        sell[1]=prices[1]-prices[0];
        
        for(int i=2;i<n;i++){
            cooldown[i]=(sell[i-1]>cooldown[i-1])?sell[i-1]:cooldown[i-1];
            sell[i]=prices[i]-prices[i-1]+((sell[i-1]>cooldown[i-2])?sell[i-1]:cooldown[i-2]);
        }
        
        return (sell[n-1]>cooldown[n-1])?sell[n-1]:cooldown[n-1];
    }
}
