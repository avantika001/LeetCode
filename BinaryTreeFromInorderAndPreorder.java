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
    int pIndex=0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        if(preorder==null||inorder==null) return null;
        
        Stack<TreeNode> st=new Stack<>();
        Set<TreeNode> set=new HashSet<>();
        TreeNode root=null;
        
        for(int pre=0,in=0;pre<preorder.length;){
            TreeNode node=null;
            
            do{
                node=new TreeNode(preorder[pre]);
                
                if(root==null)
                    root=node;
                
                if(!st.empty()){
                    if(set.contains(st.peek())){
                        set.remove(st.peek());
                        st.pop().right=node;
                    }else{
                        st.peek().left=node;
                    }
                }
                
                st.push(node);
                
            }while(preorder[pre++]!=inorder[in]&&pre<preorder.length);
            
            node=null;
            
            while(!st.empty()&&in<inorder.length&&inorder[in]==st.peek().val){
                node=st.pop();
                in++;
            }
            
            if(node!=null){
                set.add(node);
                st.push(node);
            }
        }
        
        return root;
    }
    
}
