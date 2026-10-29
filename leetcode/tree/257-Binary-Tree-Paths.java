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
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        
        ans.clear();

        List<Integer> lst = new ArrayList<>(List.of(root.val)); // min no. of nodes = 1
        helper(root,lst);
        
        return ans;
    }

    private void helper(TreeNode root,List<Integer> lst){
        if(root == null) return; // do nothing
        if(root.left == null && root.right == null){
            // since it is leaf node
            // add the path
            String s = lst.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("->"));
            ans.add(s);
            return;
        }
        if(root.left != null){
            lst.add(root.left.val);
            helper(root.left,lst); // root.left ka hi new sum = sum + root.val hai with its current path
            lst.removeLast();
        }

        if(root.right != null){
            lst.add(root.right.val);
            helper(root.right,lst); // root.left ka hi new sum = sum + root.val hai with its current path
            lst.removeLast();
        }
    }
}