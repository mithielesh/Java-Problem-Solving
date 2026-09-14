// import javax.swing.tree.TreeNode;

import javax.swing.tree.TreeNode;

public class maxAncestorNodeDiff {
    private int diff;
    public int maxAncestorDiff(TreeNode root) {
        diff = 0;
        helper(root,0);
        return diff;
    }
    private int[] helper(TreeNode root, int parentVal) {
        if(root == null) {
            return new int[]{parentVal,parentVal};
        }
        int[] left = helper(root.left,root.val);
        int[] right = helper(root.right,root.val);
        int current = root.val, max = Math.max(left[1], right[1]), min = Math.min(left[0], right[0]);
        int minDiff = (int)Math.abs(current - min), maxDiff = (int)Math.abs(max - current);
        diff = Math.max(diff, Math.max(minDiff, maxDiff));
        return new int[]{Math.min(current,min), Math.max(current,max)};
    }
}
