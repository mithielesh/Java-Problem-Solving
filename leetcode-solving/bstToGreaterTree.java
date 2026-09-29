public class bstToGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        sum = treeSum(root);
        converter(root);
        return root;
    }
    private void converter(TreeNode root) {
        if(root == null) {
            return;
        }
        converter(root.left);
        int temp = root.val;
        root.val = sum;
        sum -= temp;
        converter(root.right);
    }
    private int treeSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = treeSum(root.left);
        int right = treeSum(root.right);
        return left + right + root.val;
    }
}