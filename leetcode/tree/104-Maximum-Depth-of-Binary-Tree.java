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
   // int max = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode rem = q.removeFirst();
                if(rem.left != null) q.addLast(rem.left);
                if(rem.right != null) q.addLast(rem.right);
            }
            ans++;
        }
        return ans;
    }
}