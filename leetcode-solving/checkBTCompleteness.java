public class checkBTCompleteness {
    public boolean isCompleteTree(TreeNode root) {
        boolean limit = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                
                TreeNode node = q.poll();

                if(limit && (node.right != null || node.left != null)) {
                    return false;
                }
                if(node.left == null && node.right != null) {
                    return false;
                }
                if(node.right == null) {

                    /*If we encounter an null right node in any case there should be more nodes after it
                    Because be it a single child case or filled case. The limit has been reached */

                    if(node.left != null && limit) {
                        return false;
                    }
                    limit = true;
                } 

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return true;
    }
}