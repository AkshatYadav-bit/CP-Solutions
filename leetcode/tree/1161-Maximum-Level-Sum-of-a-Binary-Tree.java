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
    public int maxLevelSum(TreeNode root) {
       
        Deque<TreeNode> q = new ArrayDeque<>();

        q.addLast(root);
        int ind = 1;
        int ans = 1;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int sum = 0;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode rem = q.removeFirst();
                sum += rem.val;
                if(rem.left != null) q.addLast(rem.left);
                if(rem.right != null) q.addLast(rem.right);
            }
            if(max < sum){
                max = sum;
                ans = ind;
            }
            ind++;
        }
        return ans;
    }
}