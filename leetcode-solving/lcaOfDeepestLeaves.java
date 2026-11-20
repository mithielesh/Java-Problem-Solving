public class lcaOfDeepestLeaves {
    public TreeNode lcaDeepestLeaves {
        if(root.left == null && root.right == null) {
            return root;
        }
        int height = findHeight(root);
        return deepestNode(root,height-1);
    }
    private TreeNode deepestNode(TreeNode root, int height) {
        if(root == null) {
            return null;
        }
        if(height == 0) {
            return root;
        }
        TreeNode left = deepestNode(root.left, height-1);
        TreeNode right = deepestNode(root.right, height-1);
        if(left != null && right != null) {
            return root;
        }
        else if(left != null) {
            return left;
        }
        else if(right != null) {
            return right;
        }
        return null;
    }
    private int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left, right) + 1;
    }
}