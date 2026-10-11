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
public class designLinkedList {

    ListNode head, tail;
    int len;

    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        setup(head, tail);
        len = 0;
    }

    public void setup(ListNode head, ListNode tail) {
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        if(index < 0 || index >= len) {
            return -1;
        }
        if(index == 0) {
            return head.next.data;
        }
        if(index == len-1) {
            return tail.prev.data;
        }
        ListNode curNode = head.next;
        while(index != 0) {
            curNode = curNode.next;
            index--;
        }
        return curNode.data;
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        len++;
    }
    
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        len++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > len) {
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == len) {
            addAtTail(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode curNode = head.next;
        while(index != 0) {
            curNode = curNode.next;
            index--;
        }
        // Add behind where the pointer is
        curNode.prev.next = node;
        node.prev = curNode.prev;
        node.next = curNode;
        curNode.prev = node;
        len++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= len) {
            return;
        }
        if(index == 0) {
            head.next.next.prev = head;
            head.next = head.next.next;
            len--;
            return;
        }
        if(index == len-1) {
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            len--;
            return;
        }
        ListNode curNode = head.next;
        while(index != 0) {
            curNode = curNode.next;
            index--;
        }
        curNode.next.prev = curNode.prev;
        curNode.prev.next = curNode.next;
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */