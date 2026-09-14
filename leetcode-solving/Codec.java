/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder preorder = new StringBuilder();
        serializer(root,preorder);
        return preorder.toString();
    }
    private void serializer(TreeNode root, StringBuilder preorder) {
        if(root == null) {
            return;
        }
        preorder.append(root.val).append("-");
        serializer(root.left,preorder);
        serializer(root.right,preorder);
    }

    int index;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String[] arr = data.split("-");
        index = 0;
        return deserializer(arr,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private TreeNode deserializer(String[] arr, int low, int high) {
        if(index == arr.length) {
            return null;
        }
        int curVal = Integer.parseInt(arr[index]);
        if(curVal < low || curVal > high) {
            return null;
        }
        index++;
        TreeNode node = new TreeNode(curVal);
        node.left = deserializer(arr,low,curVal);
        node.right = deserializer(arr,curVal,high);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;