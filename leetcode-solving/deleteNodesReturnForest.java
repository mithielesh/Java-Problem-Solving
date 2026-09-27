public class deleteNodesReturnForest {
    HashSet<Integer> hashTable;
    List<TreeNode> trees;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        hashTable = new HashSet<>();
        for(int node : to_delete) {
            hashTable.add(node);
        }
        trees = new ArrayList<>();
        if(!hashTable.contains(root.val)) {
            trees.add(root);
        }
        cutter(root);
        return trees;
    }
    private void cutter(TreeNode root) {
        if(root == null) {
            return;
        }
        cutter(root.left);
        cutter(root.right);
        if(root.left != null && hashTable.contains(root.left.val)) {
            root.left = null;
        }
        if(root.right != null && hashTable.contains(root.right.val)) {
            root.right = null;
        }
        if(hashTable.contains(root.val)) {
            if(root.left != null) {
                trees.add(root.left);
                root.left = null;
            }
            if(root.right != null) {
                trees.add(root.right);
                root.right = null;
            }
        }
    }
}