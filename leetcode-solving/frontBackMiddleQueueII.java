import java.util.*;

class ListNode {
    int data;
    ListNode prev;
    ListNode next;

    public ListNode(int val) {
        this.data = val;
        this.prev = null;
        this.next = null;
    }
}

// Using this method to make the insertions and deletions O(1) operation
// When there are two middle position choices, the operation is performed on the frontmost middle position choice
// -1 -> 3 -> 4 -> 5 -> 2 -> -1            size = 4, mid = 1

public class frontBackMiddleQueueII {

    ListNode head, tail, midNode;
    int size, mid;

    // -1 -> 7 -> 2 -> 3 -> (4) -> 5 -> 6 -> -1
    private static void pushFront(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
        if(size == 1) {
            midNode = midNode.next;
        }
        else if(size % 2 == 0) {
            midNode = midNode.prev;
        }
    }
    // -1 -> (2) -> 3 -> -1

    // In the case of an odd sized queue the insertion happens before the mid. In the case of even sized it happens after it
    private static void pushMiddle(int val) {
        ListNode node = new ListNode(val);
        if(size % 2 == 0) {
            node.next = midNode.next;
            node.prev = midNode;
            midNode.next.prev = node;
            midNode.next = node;
            // Set the midNode correctly after the addition
            midNode = midNode.next;
        }
        else {
            node.next = midNode;
            node.prev = midNode.prev;
            midNode.prev.next = node;
            midNode.prev = node;
            // Set the midNode correctly after the addition
            midNode = midNode.prev;
        }
        size++;
    }
    private static void pushBack(int val) {
        ListNode node = new ListNode(val);
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        size++;
        if(size % 2 == 1) {
            midNode = midNode.next;
        }
    }
    // -1 -> (4) -> 5 -> 6 -> -1
    // -1 -> -1
    private static int popFront() {
        if(head.next == tail) {
            return -1;
        }
        ListNode node = head.next;
        int val = node.data;
        node.next.prev = head;
        head.next = node.next;
        size--;
        if(size % 2 == 1) {
            midNode = midNode.next;
        }
        else if(size == 0) {
            midNode = head;     // If size = 0, midNode is lost, so bring it back to head
        }
        return val;
    }
    // -1 -> 1 -> (3) -> 4 -> -1
    // -1 -> -1
    private static int popMiddle() {
        if(midNode == head || midNode == tail) {
            return -1;
        }
        ListNode node = midNode;
        int val = node.data;
        midNode = midNode.next;
        node.prev.next = midNode;
        midNode.prev = node.prev;
        size--;
        if(size % 2 == 0) {
            midNode = midNode.prev;     // If size = 0, returning from tail to head
        }
        return val;
    }
    // -1 -> 2 -> (3) -> 4 -> -1
    // -1 -> -1
    private static int popBack() {
        if(tail.prev == head) {
            return -1;
        }
        ListNode node = tail.prev;
        int val = node.data;
        node.prev.next = tail;
        tail.prev = node.prev;
        size--;
        if(size % 2 == 0) {
            midNode = midNode.prev;     // If size = 0, returning from tail to head
        }
        return val;
    }

    public static void main(String[] args) {
        // Initializing
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
        mid = head;
        size = 0, mid = 0;
    }
}
