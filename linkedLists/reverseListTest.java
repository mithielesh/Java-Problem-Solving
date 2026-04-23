import core.Node;

public class reverseListTest {
    private static Node reverse(Node head) {
        Node ptr = head;
        Node curNode = head;
        Node prev = null;
        while(curNode != null) {
            Node next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }
        // ptr.next = prev;      -- Causes the looping so returned correctly
        return ptr;
    }
    private static Node convertAll(int[] arr){
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    private static void printAll(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        Node head = convertAll(arr);
        head = reverse(head);
        printAll(head);
    }
}
