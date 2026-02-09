import core.Node;
public class swapNodes {
    private static Node swapper(Node head){
        // For no or 1 element there is no swapping
        if(head == null || head.next == null) return head;
        // We are using another linked list to store this
        Node n1 = head;
        Node n2 = head.next;
        Node tempHead = new Node(-1);
        Node temp = tempHead;
        while(n2 != null && n2.next != null){
            Node m1 = new Node(n1.data);
            Node m2 = new Node(n2.data);
            temp.next = m2;
            temp = temp.next;
            temp.next = m1;
            n1 = n1.next.next;
            n2 = n2.next.next;
            temp = temp.next;
        }
        if(n1 != null && n2 != null){
            Node m1 = new Node(n1.data);
            Node m2 = new Node(n2.data);
            temp.next = m2;
            temp = temp.next;
            temp.next = m1;
        }
        else{
            temp.next = n1;
        }
        tempHead = tempHead.next;
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
        int[] arr = {2,1};
        Node head = convertAll(arr);
        head = swapper(head);
        printAll(head);
    }
}
