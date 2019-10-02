class Solution {
    public int repeatedStringMatch(String A, String B) {
        int na=A.length();
        int nb=B.length();
        
        int count=0;
        
        String str="";
        for(;str.length()<nb;count++){
            str+=A;
        }
        
        if(str.indexOf(B)>-1)return count;
        
        str+=A;
        
        if(str.indexOf(B)>-1)return count+1;
        
        return -1;
        
        
    }
}
