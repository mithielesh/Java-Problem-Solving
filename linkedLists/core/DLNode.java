package core;

public class DLNode {
    public int val;
    public DLNode prev;
    public DLNode next;

    public DLNode(DLNode prev1, int val1, DLNode next1){
        this.prev = prev1;
        this.val = val1;
        this.next = next1;
    }
    public DLNode(DLNode prev1, int val1){
        this.prev = prev1;
        this.val = val1;
        this.next = null;
    }
    public DLNode(int val1, DLNode next1){
        this.prev = null;
        this.val = val1;
        this.next = next1;
    }
    public DLNode(int val1){
        this.prev = null;
        this.val = val1;
        this.next = null;
    }
}
