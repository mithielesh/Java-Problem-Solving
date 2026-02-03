import core.Node;
import java.util.*;
public class addTwoNumbers {
    private static Node add(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        int carry = 0;
        List<Integer> list = new ArrayList<>();
        while(temp1 != null || temp2 != null){
            int a = 0, b = 0;
            if(temp1 != null){
                a = temp1.data;
            }
            if(temp2 != null){
                b = temp2.data;
            }
            int sum = a + b + carry;
            if(sum > 10){
                carry = 1;
                int val = sum % 10;
                list.add(val);
            }
            else{
                list.add(sum);
                carry = 0;
            }
            if(temp1 != null){
                temp1 = temp1.next;
            }
            if(temp2 != null){  
                temp2 = temp2.next;
            }
        }
        if(carry == 1){
            list.add(1);
        }
        Node n = new Node(list.get(0));
        Node head = n;
        Node temp = head;
        for(int i = 1; i < list.size(); i++){
            Node n1 = new Node(list.get(i));
            temp.next = n1;
            temp = temp.next;
        }
        return head;
    }
    private static Node addAnotherWay(Node l1, Node l2){
        Node head = new Node(-1);
        Node cur = head;
        Node temp1 = l1, temp2 = l2;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            int a = 0, b = 0;
            if(temp1 != null){
                a = temp1.data;
            }
            if(temp2 != null){
                b = temp2.data;
            }
            int sum = a + b + carry;
            if(sum > 9){
                carry = 1;
                int val = sum % 10;
                Node n = new Node(val);
                cur.next = n;
                cur = cur.next;
            }
            else{
                carry = 0;
                Node n = new Node(sum);
                cur.next = n;
                cur = cur.next;
            }
        }
        if(carry == 1){
            Node n = new Node(1);
            cur.next = n;
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
        int[] arr = {1,2,3,4,5};
        int[] brr = {1,7,4,3,9};
        Node head1 = convertAll(arr);
        Node head2 = convertAll(brr);
        Node head = add(head1,head2);
        printAll(head);
    }
}
