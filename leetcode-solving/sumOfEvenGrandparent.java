public class sumOfEvenGrandparent {
    int sum;
    public int sumEvenGrandparent(TreeNode root) {
        // If current node is even check if child exist if yes, check if grand child exists and sum it up
        sum = 0;
        getSum(root);
        return sum;
    }
    private void getSum(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.val % 2 == 0) {
            if(root.right != null) {
                if(root.right.right != null) {
                    sum += root.right.right.val;
                }
                if(root.right.left != null) {
                    sum += root.right.left.val;
                }
            }
            if(root.left != null) {
                if(root.left.right != null) {
                    sum += root.left.right.val;
                }
                if(root.left.left != null) {
                    sum += root.left.left.val;
                }
            }
        }
        getSum(root.left);
        getSum(root.right);
    }
}