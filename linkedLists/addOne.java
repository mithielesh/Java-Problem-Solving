import core.Node;
public class addOne {
    private static Node add(Node head){
        Node temp = head;
        int carry = helper(temp);
        if(carry == 1){
            Node n1 = new Node(1);
            n1.next = head;
            head = n1;
        }
        return head;
    }
    private static int helper(Node temp){
        if(temp == null){
            return 1;
        }
        int val = temp.data;
        int carry = helper(temp.next);
        int sum = val + carry;
        if(sum > 9){
            temp.data = sum % 10;
            return 1;
        } 
        temp.data = sum;
        return 0;
    }
    /* 
    private static Node add(Node head){
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while(temp != null){
            int val = temp.data;
            int sum = val + carry;
            if(sum > 9){
                carry = 1;
                temp.data = sum % 10;
            }
            else{
                temp.data = sum;
                carry = 0;
            }
            temp = temp.next;
        }
        head = reverse(head);
        if(carry == 1){
            Node n1 = new Node(carry);
            n1.next = head;
            head = n1;
        }
        return head;
    }
    private static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    */
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
        int[] arr = {9,9,9,9,9};
        int[] brr = {1,7,4,3,9};
        Node head1 = convertAll(arr);
        Node head2 = convertAll(brr);
        Node head = add(head1);
        printAll(head);
    }
}
