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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans.clear();
        if(root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();

        q.addLast(root);
        while(q.size() > 0){
           int size = q.size();
           List<Integer> processed = new ArrayList<>();
           for(int i = 0 ; i < size ; i++){
                // remove it
                TreeNode removed = q.removeFirst();

                // process it i.e. add in result
                processed.add(removed.val);

                // add its all possible childrens
                if(removed.left != null) q.addLast(removed.left);
                if(removed.right != null) q.addLast(removed.right);
           }
           ans.add(processed);
        }
        return ans;
    }
}