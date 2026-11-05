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
public class cousinBT {
    public TreeNode replaceValueInTree(TreeNode root) {
        int height = findHeight(root);
        int[] lvlSum = new int[height];
        findLevelSum(root,lvlSum,0);
        root.val = 0;
        lvlSum[0] = 0;
        replacer(root,lvlSum,1);
        return root;
    }
    private void replacer(TreeNode root, int[] lvlSum, int lvl) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        int left = 0, right = 0;
        if(root.left != null) {
            left = root.left.val;
        }
        if(root.right != null) {
            right = root.right.val;
        }
        int sumDiff = lvlSum[lvl] - (left + right);
        if(root.left != null) {
            root.left.val = sumDiff;
        }
        if(root.right != null) {
            root.right.val = sumDiff;
        }
        replacer(root.left,lvlSum,lvl+1);
        replacer(root.right,lvlSum,lvl+1);
    }
    private void findLevelSum(TreeNode root, int[] lvlSum, int lvl) {
        if(root == null) {
            return;
        }
        lvlSum[lvl] += root.val;
        findLevelSum(root.left,lvlSum,lvl+1);
        findLevelSum(root.right,lvlSum,lvl+1);
    }
    private int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left,right) + 1;
    }
}