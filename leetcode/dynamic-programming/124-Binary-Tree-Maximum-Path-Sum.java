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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE; // we have min no. of nodes = 1
        helper(root); // gives maximum sum from root to leaf node
        return max;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;

        int s1 = helper(root.left);
        int s2 = helper(root.right);
        max = Math.max(root.val,max);
        max = Math.max(s1+root.val,max);
        max = Math.max(s2+root.val,max);
        max = Math.max(s1+s2+root.val,max);
        return root.val + Math.max(Math.max(s1,s2),0);
    }
}