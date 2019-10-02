/* compress string in-place */

class Solution {
    public int compress(char[] chars) {
        char c=chars[0];
        int n=chars.length;
        int j=0;
        int count=0;
        int length=0;
        for(int i=0;i<n;i++){
           if(chars[i]==c){
               count++;
           }
            if(i+1>=n||chars[i+1]!=c){
                chars[j++]=c;
                length++;
                if(count!=1){
                    String str=Integer.toString(count);
                    for(int k=0;k<str.length();k++){
                        chars[j++]=str.charAt(k);
                        length++;
                    }
                }
                if(i+1<n){
                    c=chars[i+1];
                }
                count=0;
            }
        }
        
        return length;
    }
}
