import core.Node;
public class mergeSortedLists {
    // Extreme brute force would be to add them to another array and sort it
    // Then add them to a new list
    // Optimal would be to use the merge strategy used in merge sort
    public static Node merge(Node l1,Node l2){
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Node head = new Node(-1);
        Node temp = head;
        Node i = l1;
        Node j = l2;
        while(i != null && j != null){
            if(i.data <= j.data){
                Node n1 = new Node(i.data);
                temp.next = n1;
                i = i.next;
            }
            else{
                Node n1 = new Node(j.data);
                temp.next = n1;
                j = j.next;
            }
            temp = temp.next;
        }
        while(i != null){
            Node n1 = new Node(i.data);
            temp.next = n1;
            temp = temp.next;
            i = i.next;
        }
        while(j != null){
            Node n1 = new Node(j.data);
            temp.next = n1;
            temp = temp.next;
            j = j.next;
        }
        head = head.next;
        return head;
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
        int[] arr = {1,14,15,21,24};
        int[] brr = {5,10,20,30};
        Node head1 = convertAll(arr);
        Node head2 = convertAll(brr);
        Node head = merge(head1,head2);
        printAll(head);
    }
}
