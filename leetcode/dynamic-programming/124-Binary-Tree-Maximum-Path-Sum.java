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
        //• If both s1 and s2 are negative numbers (e.g., -5 and -10), Math.max(s1, s2) will pick -5.
        // • You will then return root.val + (-5), which actively reduces the maximum path sum available to the parent node.
        // • Since a path can choose not to extend into a child subtree, any negative sum contribution should be clamped to 0
    }
}