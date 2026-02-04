import core.Node;
public class middleOfList {
    private static Node middleNode(Node head){
        // No mid point for 0 or 1 element list
        if(head == null || head.next == null){
            return head;
        }
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        Node head = convertAll(arr);
        Node  node = middleNode(head);
        System.out.println(node.data);
    }
}
