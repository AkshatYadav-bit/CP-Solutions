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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }

    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null; // means that ancestor root doesn't contain p or q
        if(root == p || root == q){
            return root; // means that ancestor root does has p or q
        }
        TreeNode left = solve(root.left,p,q); // what target does root.left contain -> p or q or null
        TreeNode right = solve(root.right,p,q);

        if((left == p && right == q) || ( left == q && right == p)){
            return root; // this root is LCS
        }

        // here if either left or right is equal to null

        return (left != null)?left:right;
    }
}