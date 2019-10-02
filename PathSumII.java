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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        path(root,sum,a,ans);
        return ans;
    }
    
    void path(TreeNode root,int sum,List<Integer> li,List<List<Integer>> ans){
        if(root==null) return;
        li.add(root.val);
        sum=sum-root.val;
        if(root.left==null&&root.right==null){
            if(sum==0){
                List<Integer> temp=new ArrayList<>();
                for(int i=0;i<li.size();i++)
                    temp.add(li.get(i));
                ans.add(temp);
            }
        }
        
        path(root.left,sum,li,ans);
        path(root.right,sum,li,ans);
        li.remove(li.size()-1);
        return;
    }
}
