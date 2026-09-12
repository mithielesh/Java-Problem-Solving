import javax.swing.tree.TreeNode;

public class sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return treeCreator(head);
    }
 
    // 1 -> 2 -> 3 -> 4
    private TreeNode treeCreator(ListNode start, ListNode end) {
        if(start == end) {
            return null;
        }
        ListNode slow = start, fast = start;
        while(fast.next != end && fast.next.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        TreeNode left = treeCreator(start, slow);
        TreeNode right = treeCreator(slow.next, end);

        node.left = left;
        node.right = right;
        return node;
    } 
}