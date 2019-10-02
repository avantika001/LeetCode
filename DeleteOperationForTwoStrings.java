/* Input: "sea", "eat"
Output: 2 */

class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length(),n2=word2.length();
        int memo[][]=new int[n1+1][n2+1];
        int count=LCS(word1,word2,n1,n2,memo);
        return (n1+n2-2*count);
    }
    public static int LCS(String word1,String word2,int n1,int n2,int[][] memo){
       
        if(n1==0||n2==0) return 0;
        if(memo[n1][n2]>0) return memo[n1][n2];
        if(word1.charAt(n1-1)==word2.charAt(n2-1)){
            memo[n1][n2]=LCS(word1,word2,n1-1,n2-1,memo)+1;
        }
        else{
            memo[n1][n2]=Math.max(LCS(word1,word2,n1-1,n2,memo),LCS(word1,word2,n1,n2-1,memo));
        }
        return memo[n1][n2];
    }
}
