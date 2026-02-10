import core.Node;
public class partitionList {
    private static Node partition(Node head, int k){
        if(head == null || head.next == null) return head;
        Node smallHead = new Node(-1);
        Node small = smallHead;
        Node largeHead = new Node(-1);
        Node large = largeHead;
        Node temp = head;
        while(temp != null){
            if(temp.data < k){
                Node n = new Node(temp.data);
                small.next = n;
                small = small.next;
            }
            else{
                Node m = new Node(temp.data);
                large.next = m;
                large = large.next;
            }
            temp = temp.next;
        }
        smallHead = smallHead.next;
        largeHead = largeHead.next;
        if(smallHead == null) return largeHead;
        if(largeHead == null) return smallHead;
        small.next = largeHead;
        return smallHead;
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
        head = partition(head,k);
        printAll(head);
    }
}
