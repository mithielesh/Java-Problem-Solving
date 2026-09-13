// import javax.swing.tree.TreeNode;

public class nodeAvgSumSubtree {
    private int count;
    public int averageOfSubtree(TreeNode root) {
        // improved
        count = 0;
        helperII(root);
        return count;
    }
    private int[] helperII(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        int[] leftSubtree = helper(root.left);
        int[] rightSubtree = helper(root.right);
        int sum = root.val + leftSubtree[0] + rightSubtree[0];
        int nodeCount = 1 + leftSubtree[1] + rightSubtree[1];
        int avg = sum / nodeCount;
        if(root.val == avg) {
            count++;
        }
        return new int[]{sum, nodeCount};
    }



    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        nodeCounter = 1;
        int rightSum = sumCalc(root.right);
        int leftSum = sumCalc(root.left);
        int current = root.val;
        int avg = (rightSum + leftSum + current) / nodeCounter;
        if(root.val == avg) {
            count++;
        }
        helper(root.left);
        helper(root.right);
    }
    private int sumCalc(TreeNode root) {
        if(root == null) {
            return 0;
        }
        nodeCounter++;
        int leftSum = sumCalc(root.left);
        int rightSum = sumCalc(root.right);
        return root.val + leftSum + rightSum;
    }    
}