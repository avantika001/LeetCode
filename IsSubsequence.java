class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int i=0;
        int len=s.length();
        if(len==0)return true;
        int len2=t.length();
        int j=0;
        while(t.length()!=0&&j<len){
            int index=t.indexOf(s.charAt(j++));
            if(index<=-1)return false;
            t=t.substring(index+1,t.length());
        }
        
        if(j==len)return true;

        return false;
    }
}
