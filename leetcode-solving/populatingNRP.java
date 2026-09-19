public class populatingNRP {
    public Node connect(Node root) {
        connector(root);
        return root;
    }
    private void connector(Node root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connector(root.left);
        connector(root.right);
    }
}
