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
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        helper(root);
        return sum;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        TreeNode node = root.left;
        if( node != null && node.left == null && node.right == null) sum += node.val;
        helper(root.left);
        helper(root.right);
    }
}