import core.Node;
import java.util.*;
public class oddEvenList {
    private static Node oddEvenOpt(Node head){
        if(head == null || head.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    private static Node oddEvenBrute(Node head){
        if(head == null || head.next == null) return head;
        List<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp != null && temp.next != null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        // Add the last element in an odd length list
        if(temp != null) list.add(temp.data);
        temp = head.next;
        while(temp != null && temp.next != null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        // Add the last element in an even length list
        if(temp != null) list.add(temp.data);
        // Data replacement
        temp = head;
        for(int val : list){
            temp.data = val;
            temp = temp.next;
        }
        return head;
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
        head = oddEvenOpt(head);
        printAll(head);
    }
}
