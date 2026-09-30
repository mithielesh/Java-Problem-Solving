public class insufficientNodesInPath {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int val = deleter(root,0,limit);
        if(val < limit)  {
            return null;
        }
        return root;
    }
    private int deleter(TreeNode root, int sum, int limit) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        if(root.right == null && root.left == null) {
            return sum + root.val;
        }
        sum += root.val;
        int leftSum = deleter(root.left,sum,limit);
        int rightSum = deleter(root.right,sum,limit);
        if(leftSum == Integer.MIN_VALUE) {
            return rightSum;
        }
        if(rightSum == Integer.MIN_VALUE) {
            return leftSum;
        }
        if(leftSum < limit && rightSum < limit) {
            return leftSum;     // We can return any one
        }
        if(leftSum < limit) {
            root.left = null;
            return rightSum;
        }
        if(rightSum < limit) {
            root.right = null;
            return leftSum;
        }
        return leftSum;     // We can return any one
    }
}