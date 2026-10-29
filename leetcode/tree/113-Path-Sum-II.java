/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int k) {
        ans.clear();
        List<Integer> lst = new ArrayList<>();
        int sum = 0;
        helper(root,k,sum,lst);
        return ans;
    }

    private void helper(TreeNode root,int k,int sum,List<Integer> lst){
        if(root == null) return ; // because its not leaf node
        if(root.left == null && root.right == null) { // its leaf node
            if(sum+root.val == k){
                lst.add(root.val);
                ans.add(List.copyOf(lst));
                lst.removeLast();
                return;
            }
            else return; // do nothing
        }

        lst.add(root.val);
        helper(root.left,k,root.val+sum, lst); // root.left ke pehle kitna sum hua aur kya lst hai uske path ka
        helper(root.right,k,root.val+sum, lst); // similarly for root.right
        lst.removeLast();
    }
}