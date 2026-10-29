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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return -1;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        int ans = root.val;
        while(!q.isEmpty()){
            int leftmost = 0;
            boolean foundleftmost = false;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                
                TreeNode rem = q.removeFirst();
                if(!foundleftmost){
                    leftmost = rem.val;
                    foundleftmost = true;
                }
                if(rem.left != null) q.addLast(rem.left);
                if(rem.right != null) q.addLast(rem.right);
            }
            ans = leftmost;
        }
        return ans;
    }
}