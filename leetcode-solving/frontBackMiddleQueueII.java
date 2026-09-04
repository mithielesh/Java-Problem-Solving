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

public class frontBackMiddleQueueII {
    
    ListNode head, tail, midNode;
    int size, mid;

    private static void pushFront(int val) {

    }
    private static void pushMiddle(int val) {

    }
    private static void pushBack(int val) {

    }
    private static int popFront() {

    }
    private static int popMiddle() {
        
    }
    private static int popBack() {
        
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
