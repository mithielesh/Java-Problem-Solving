import core.Node;
public class rotateList {
    // Better approach is to make the list circular and then use it
    private static Node rotateOpt(Node head, int k){
        if(head == null || head.next == null) return head;
        Node temp = head;
        int length = 1;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        temp.next = head;
        int n = k % length;
        int jumps = length - n - 1;
        temp = head;
        while(jumps != 0){
            temp = temp.next;
            jumps--;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
    private static Node rotate(Node head, int rotate){

        int n = length(head);
        int actual = rotate % n;
        if(actual > 0){
            Node slow = head;
            Node fast = head;
            while(fast.next != null){
                if(actual != 0){
                    fast = fast.next;
                    actual--;
                    continue;
                }
                fast = fast.next;
                slow = slow.next;
            }
            Node secHead = slow.next;
            slow.next = null;
            fast.next = head;
            return secHead;
        }
        return head;
    }
    private static int length(Node head){
        Node temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    private static Node convertAll(int[] arr){
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
        int[] arr = {1,2,3,4,5};
        int rotate = 5;
        Node head = convertAll(arr);
        head = rotateOpt(head,rotate);
        printAll(head);
    }
}
