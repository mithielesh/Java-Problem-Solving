public class dominantNodes {
    int count;
    public int countDominantNodes(TreeNode root) {
        // Every leaf node is dominant, and then check the parent nodes one by one
        count = 0;
        counter(root);
        return count;
    }
    private int counter(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = counter(root.left);
        int right = counter(root.right);
        int max = Math.max(left, right);
        if(root.val < max) {
            return max;
        }
        count++;
        return root.val;
    }
}