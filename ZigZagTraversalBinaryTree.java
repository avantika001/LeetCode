/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> li=new ArrayList<>();
        if(root==null) return li;
        li=ZigZag(root,li);
        return li;
    }
    public List<List<Integer>> ZigZag(TreeNode root,List<List<Integer>> li){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean even=true;
        while(!q.isEmpty()){
            ArrayList<Integer> arr=new ArrayList<>();
            int len=q.size();
            if(even){
                even=!even;
                for(int i=0;i<len;i++){
                    TreeNode temp=q.poll();
                    arr.add(temp.val);
                    if(temp.left!=null) q.add(temp.left);
                    if(temp.right!=null) q.add(temp.right);
                }
            }else{
                Stack<Integer> st=new Stack<>();
                even=!even;
                for(int i=0;i<len;i++){
                    TreeNode temp=q.poll();
                    st.push(temp.val);
                    if(temp.left!=null) q.add(temp.left);
                    if(temp.right!=null) q.add(temp.right);
                }
                while(!st.empty()){
                    arr.add(st.pop());
                }
                
            }
            li.add(arr);
        }
        return li;
    }
}
