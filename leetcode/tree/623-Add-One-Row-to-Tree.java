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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return root = newNode;    
        }
        Deque<TreeNode> q = new ArrayDeque<>();

        q.addLast(root);
        int ind = 1;

        while(!q.isEmpty()){
            List<TreeNode> lst = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                
                TreeNode rem = q.removeFirst();
                if(ind == depth-1) lst.add(rem);
              
                if(rem.left != null) q.addLast(rem.left);
                if(rem.right != null) q.addLast(rem.right);
            }
            if(ind == depth-1){
                for(TreeNode rem : lst){
                    TreeNode leftnode = rem.left;
                    TreeNode rightnode = rem.right;
                    
                    rem.left = new TreeNode(val);
                    rem.right = new TreeNode(val);

                    rem.left.left = leftnode;
                    rem.right.right = rightnode;
                }
                return root;
            }
           
            ind++;
        }
        return root;
        
    }
}