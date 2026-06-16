import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class treeFromSortedArray {
    private static TreeNode sortedArrayToBST(int[] nums) {
        return treeCreator(nums,0,nums.length-1);
    }
    private static TreeNode treeCreator(int[] nums, int start, int end) {
        if(start == end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode left = treeCreator(nums,start,mid-1);
        TreeNode right = treeCreator(nums,mid+1,end);
        
        node.left = left;
        node.right = right;
        return node;
    }

    private static void printTree(TreeNode root) {
        // using preorder
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = sortedArrayToBST(arr);
        printTree(root);
        sc.close();
    }
}