import core.Node;
import java.util.*;
public class reverseList {
    // Optimal method
    private static Node reverseOpt(Node head){
        if(head == null || head.next == null) return head;
        
        Node temp = head, prev = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    //Brute Force Method
    // Can use a stack or arraylist
    private static Node reverse(Node head){
        List<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            list.add(temp.data);
            temp = temp.next;
        }
        int r = list.size()-1, l=0;
        while(l < r){
            Collections.swap(list,l,r);
            l++;
            r--;
        }
        temp = head;
        for(int n : list){
            temp.data = n;
            temp = temp.next;
        }
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
        Node head = convertAll(arr);
        head = reverseOpt(head);
        printAll(head);
    }
}
