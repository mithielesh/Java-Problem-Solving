import core.Node;
public class reverseSizeK {
    private static Node reverseLLSizeK(Node head, int k){
        if(k == 1) return head;
        // Create a tempHead where the partition ends
        Node tempHead = head;
        Node prev = null;
        while(k != 0){
            prev = tempHead;
            tempHead = tempHead.next;
            k--;
        }
        // make the part isolated
        prev.next = null;
        // Now for the reverse part
        Node mainHead = reverse(head);
        mainHead.next = tempHead;
        return prev;
    }
    private static Node reverse(Node head){
        Node tempHead = head;
        Node prev = null;
        Node temp = head;
        Node front = head.next;
        while(front != null){
            temp.next = prev;
            prev = temp;
            temp = front;
            front = front.next;
        }
        temp.next = prev;
        prev = temp;
        temp = front;
        return tempHead;
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
        int[] arr = {1,4,3,2,5,2};
        int k = 3;
        Node head = convertAll(arr);
        head = reverseLLSizeK(head,k);
        printAll(head);
    }
}
