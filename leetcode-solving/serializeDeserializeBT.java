/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class serializeDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorderSerializer(root,sb);
        return sb.toString().trim();
    }
    public void preorderSerializer(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(-1001).append(' ');
            return;
        }
        sb.append(root.val).append(' ');
        preorderSerializer(root.left,sb);
        preorderSerializer(root.right,sb);
    }

    // Decodes your encoded data to tree.
    int index;
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String[] preorder = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(preorder[0]));
        index = 1;
        treeFormer(root,preorder);
        return root;
    }
    
    private void treeFormer(TreeNode root, String[] preorder) {
        int leftVal = Integer.parseInt(preorder[index]);
        index++;
        if(leftVal != -1001) {
            TreeNode leftNode = new TreeNode(leftVal);
            root.left = leftNode;
            treeFormer(root.left,preorder);
        }
        int rightVal = Integer.parseInt(preorder[index]);
        index++;
        if(rightVal != -1001) {
            TreeNode rightNode = new TreeNode(rightVal);
            root.right = rightNode;
            treeFormer(root.right,preorder);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));