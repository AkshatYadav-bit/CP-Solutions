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
    public boolean hasPathSum(TreeNode root, int k) {
        int sum = 0;
        return helper(root,k,sum);
    }

    private boolean helper(TreeNode root,int k,int sum){
        if(root == null) return false; // because its not leaf node
        if(root.left == null && root.right == null) {
            if(sum+root.val == k) return true;
            else return false;
        }
        return helper(root.left,k,root.val+sum) || helper(root.right,k,root.val+sum);
    }
}