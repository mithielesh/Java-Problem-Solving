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
public class treeFromDescriptions {
    private static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> nodes = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for(int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];
            TreeNode parentNode;
            if(nodes.containsKey(parent)) {
                parentNode = nodes.get(parent);
            }
            else {
                parentNode = new TreeNode(parent);
                nodes.put(parent,parentNode);
            }
            TreeNode childNode;
            if(nodes.containsKey(child)) {
                childNode = nodes.get(child);
            }
            else {
                childNode = new TreeNode(child);
                nodes.put(child,childNode);
            }
            children.add(child);
            if(isLeft == 0) {
                parentNode.right = childNode;
            }
            else {
                parentNode.left = childNode;
            }
        }
        TreeNode root = null;
        for(int key : nodes.keySet()) {
            if(!children.contains(key)) {
                root = nodes.get(key);
                break;
            }
        }
        return root;
    }
    private static void printTree(TreeNode root) {
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
        int[][] descriptions = new int[n][3];
        // descriptions[i] = [parent, child, isLeft]
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                descriptions[i][j] = sc.nextInt();
            }
        }
        TreeNode root = createBinaryTree(descriptions);
        printTree(root);
        sc.close();
    }
}