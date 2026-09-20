public class populatingNRPII {
    public Node connect(Node root) {
        connector(root);
        return root;
    }
    private void connector(Node root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            joiner(root, root.left);
        }
        else if(root.right != null) {
            joiner(root, root.right);
        }
        connector(root.left);
        connector(root.right);
    }
    private void joiner(Node root, Node child) {
        if(child.next != null) {
            return;
        }
        Node cur = root;
        while(cur != null) {
            if(cur.left != null && cur.left != child) {
                child.next = cur.left;
                child = child.next;
            }
            if(cur.right != null && cur.right != child) {
                child.next = cur.right;
                child = child.next;
            }
            cur = cur.next;
        }
    }
}
