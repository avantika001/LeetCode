class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> li=new ArrayList<String>();
        if(digits==null||digits.length()==0) return li;
        char[][] map = new char[8][];
        map[0]="abc".toCharArray();
        map[1]="def".toCharArray();
        map[2]="ghi".toCharArray();
        map[3]="jkl".toCharArray();
        map[4]="mno".toCharArray();
        map[5]="pqrs".toCharArray();
        map[6]="tuv".toCharArray();
        map[7]="wxyz".toCharArray();
        char array[]=digits.toCharArray();
        
        li.add("");
        for(char c:array){
            li=value(li,map[c-'2']);
        }
        return li;
    }
    
    public static List<String> value(List<String> li,char[] arr){
        List<String> ans=new ArrayList<String>();
        for(String s:li)
            for(char c:arr)
                ans.add(s+c);
        return ans;
    }
}
