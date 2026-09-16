import javax.swing.tree.TreeNode;

public class maxBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // This is done such that we need to find the max element from both the sides, writing the brute force approach
        return treeCreator(nums, 0, nums.length);
    }
    private TreeNode treeCreator(int[] nums, int start, int end) {
        if(start == end) {
            return null;
        }
        int maxInd = -1, max = -1;
        for(int i = start; i < end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxInd = i;
            }
        }
        TreeNode node = new TreeNode(max);
        TreeNode leftNode = treeCreator(nums,start,maxInd);
        TreeNode rightNode = treeCreator(nums,maxInd+1,end);
        
        node.left =  leftNode;
        node.right = rightNode;
        return node;
    }
}
