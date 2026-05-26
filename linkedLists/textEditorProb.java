class ListNode {
    char c;
    ListNode prev;
    ListNode next;

    public ListNode() {
        this.c = '.';
        this.prev = null;
        this.next = null;
    }
    public ListNode(char c) {
        this.c = c;
        this.prev = null;
        this.next = null;
    }
}
class TextEditor {
    // First set up the head and the tail
    private ListNode head, tail, cursor;
    private int len = 0; // Length of the actual string
    private int cursorLen = 0; // Number of chars to the left of the cursor
    public TextEditor() {
        // Intialize the head and tail
        head = new ListNode('.');
        tail = new ListNode('.');
        // Join the head and tail when intialized
        head.next = tail;
        tail.prev = head;
        cursor = head;
        len = 0;
        cursorLen = 0;
    }
    
    public void addText(String text) {
        ListNode curNode = cursor;
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            ListNode node = new ListNode(c);
            node.prev = curNode;
            node.next = curNode.next;
            curNode.next.prev = node;
            curNode.next = node;
            curNode = curNode.next;
        }
        len += text.length();
        cursorLen += text.length();
        cursor = curNode;
    }
    
    public int deleteText(int k) {
        int del = 0;
        while(cursor != head && k != 0) {
            ListNode prev = cursor.prev;
            prev.next = cursor.next;
            cursor.next.prev = prev;
            cursor = prev;
            k--;
            del++;
        }
        len -= del;
        cursorLen -= del;
        return del;
    }
    
    public String cursorLeft(int k) {
        while(cursor != head && k != 0) {
            cursor = cursor.prev;
            k--;
            cursorLen--;
        }
        StringBuilder str = new StringBuilder();
        int len = Math.min(10,cursorLen);
        ListNode curNode = cursor;
        while(len != 0) {
            str.append(curNode.c);
            len--;
            curNode = curNode.prev;
        }
        return str.reverse().toString();
    }
    
    public String cursorRight(int k) {
        while(cursor.next != tail && k != 0) {
            cursor = cursor.next;
            k--;
            cursorLen++;
        }
        StringBuilder str = new StringBuilder();
        int len = Math.min(10,cursorLen);
        ListNode curNode = cursor;
        while(len != 0) {
            str.append(curNode.c);
            len--;
            curNode = curNode.prev;
        }
        return str.reverse().toString();
    }
}
public class textEditorProb {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addText("leetcode");
        System.out.println(editor.deleteText(4));
        editor.addText("practice");
        System.out.println(editor.cursorRight(3));
        System.out.println(editor.cursorLeft(8));
        System.out.println(editor.deleteText(10));
        System.out.println(editor.cursorLeft(2));
        System.out.println(editor.cursorRight(6));
    }
}