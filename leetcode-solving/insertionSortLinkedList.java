/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class insertionSortLinkedList {
    public ListNode insertionSortList(ListNode head) {
        // Intended solution
        if(head.next == null) {
            return head;
        }
        ListNode cur = head, prev = null;
        int prevVal = -5001;
        while(cur != null) {
            int curVal = cur.val;
            if(curVal < prevVal) {
                ListNode insert = cur;
                cur = cur.next;
                prev.next = cur;
                if(head.val >= curVal) {
                    insert.next = head;
                    head = insert;
                }
                else {
                    ListNode mover = head;
                    while(mover.next != null) {
                        if(mover.next.val >= curVal) {
                            insert.next = mover.next;
                            mover.next = insert;
                            break;
                        }
                        mover = mover.next;
                    }
                }
            }
            else {
                prev = cur;
                cur = cur.next;
                prevVal = curVal;
            }
        }
        return head;
    }
}