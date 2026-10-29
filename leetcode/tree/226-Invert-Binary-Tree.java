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
    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }

    private void solve(TreeNode root){
        if(root == null) return ;
        // just swap the left and right childs
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // now recursively process for child to invert subtrees
        solve(root.left);
        solve(root.right);
    }
}