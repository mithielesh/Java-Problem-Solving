import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
// Solve this using Morris Traversal 
public class treeFromPreorder {
    private static TreeNode createBSTfromPreorder(int[] preorder) {
        // Extreme bruteforce
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1 ; i < preorder.length; i ++) {
            TreeNode temp = root;
            helper(temp, preorder[i]);
        }
        return root;
    }
    private static void helper(TreeNode temp, int val) {
        while(true) {
            if(temp.val > val) {
                if(temp.left == null) {
                    TreeNode node = new TreeNode(val);
                    temp.left = node;
                    break;
                }
                else {
                    temp = temp.left;
                }
            }
            else {
                if(temp.right == null) {
                    TreeNode node = new TreeNode(val);
                    temp.right = node;
                    break;
                }
                else {
                    temp = temp.right;
                }
            }
        }
    }
    private static void printTree(TreeNode root) {
        if(root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        for(int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        TreeNode root = createBSTfromPreorder(preorder);
        printTree(root);
        sc.close();
    }
}
