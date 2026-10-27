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
public class smallestStringFromLeaf {
    String ans;
    public String smallestFromLeaf(TreeNode root) {

        // First let us do the bruteforce, this is a bad method a string is created every single time and that is taxing for the memory efficiency

        ans = "";
        StringBuilder sb = new StringBuilder();
        helper(sb,root);
        return ans;
    }
    private void helper(StringBuilder sb, TreeNode root) {

        if(root == null) {
            return;
        }

        sb.append((char)('a' + root.val));

        if(root.right == null && root.left == null) {
            String comparer = sb.reverse().toString();
            if(ans.isEmpty() || comparer.compareTo(ans) < 0) {
                ans = comparer;
            }
            sb.reverse();
        }
        else {
            helper(sb, root.left);
            helper(sb, root.right);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}