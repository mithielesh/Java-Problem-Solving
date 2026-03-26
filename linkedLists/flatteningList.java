import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.child = null;
    }
}
public class flatteningList {
    private static ListNode flatten(ListNode head) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        ListNode temp = head;
        while(temp != null) {
            q.offer(temp);
            temp = temp.next;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTemp = dummyHead;
        while(!q.isEmpty()) {
            ListNode node = q.poll();
            dummyTemp.next = node;
            dummyTemp = dummyTemp.next;
            if(node.child != null) {
                q.offer(node.child);
            }
        }
        return dummyHead.next;
    }
    private static void printList(ListNode head) {
        ListNode temp = head;
        System.out.print(temp.val);
        temp = temp.next;
        while(temp != null) {
            System.out.print(" -> " + temp.val);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(11);
        ListNode node7 = new ListNode(12);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(5);
        ListNode node11 = new ListNode(6);
        ListNode node12 = new ListNode(8);
        node1.next = node2;
        node2.child = node3;
        node2.next = node4;
        node4.child = node5;
        node5.child = node6;
        node6.child = node7;
        node4.next = node8;
        node8.child = node9;
        node8.next = node10;
        node10.child = node11;
        node11.child = node12;
        ListNode head = node1;
        ListNode flattenedHead = flatten(head);
        printList(flattenedHead);
        // Expected output : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12
    }
}
