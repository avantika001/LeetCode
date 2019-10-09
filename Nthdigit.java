class Solution {
    public int findNthDigit(int n) {
        if(n<=9) return n;
        int digits=1;
        int num_of_digits=9;
        
        while(n-num_of_digits>0){
            n-=num_of_digits;
            digits++;
            num_of_digits=9*(int)(Math.pow(10,digits-1))*digits;
            
            if(num_of_digits<0)break;
        }
        
        int base=(int)Math.pow(10,digits-1);
        
        int num=base+(n-1)/digits;
        
        char d=Integer.toString(num).charAt((n-1)%digits);
        
        return d-'0';
        
    }
}
