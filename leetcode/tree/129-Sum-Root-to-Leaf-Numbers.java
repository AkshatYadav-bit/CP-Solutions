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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        int num = root.val; // min no. of nodes = 1
        helper(root,num);
        return ans;
    }

    private void helper(TreeNode root,int num){
        if(root == null) return; // do nothing
        if(root.left == null && root.right == null){
            // since it is leaf node
            // add the path
            ans += num;
            return;
        }
        if(root.left != null){
            helper(root.left,num*10 + root.left.val); // root.left with current num including the root.left.val
        }

        if(root.right != null) helper(root.right,num*10 + root.right.val); 
    }
}