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
    public int maxDepth(TreeNode root) {
        return fun(root,0,0);
        
    }

    int fun(TreeNode node,int i,int max){
        if (node == null){
            return Math.max(i,max);
        }
        max = fun(node.left,i+1,max);
        max = fun(node.right,i+1,max);
        return max;
    }
}