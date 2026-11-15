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
public class balanceBST {
    public TreeNode balanceBST(TreeNode root) {
        // Using the brute force method
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root,inorder);
        return balancer(inorder,0,inorder.size()-1);
    }
    private TreeNode balancer(List<Integer> inorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (end - start)/2;
        TreeNode node = new TreeNode(inorder.get(start+mid));
        node.left = balancer(inorder,start,start+mid-1);
        node.right = balancer(inorder,start+mid+1,end);
        return node;
    }
    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left,inorder);
        inorder.add(root.val);
        inorderTraversal(root.right,inorder);
    }
}