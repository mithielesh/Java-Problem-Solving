import core.Node;
public class sortList {
    private static Node sort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(isCycle(head)){
            return null;
        }
        return mergeSort(head);
    }
    private static  Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = midPoint(head);
        Node secHead = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(secHead);
        return merge(left,right);
    }
    private static Node merge(Node head, Node secHead){
        Node temp1 = head;
        Node temp2 = secHead;
        Node tempHead = new Node(Integer.MIN_VALUE);
        Node temp = tempHead;
        while(temp1 != null && temp2 != null){
            if(temp1.data <= temp2.data){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        // Both wont be equal always with perfectly alined and sorted elements
        if(temp1 != null){
            temp.next = temp1;
        }
        else if(temp2 != null){
            temp.next = temp2;
        }
        return tempHead.next;
    }
    // for the odd sized list return the mid element and for the even sized one return the first center element                            
    private static Node midPoint(Node head){
        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }                                                                     
    private static boolean isCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
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
        int[] arr = {3,2,6,4,0,1};
        Node head = convertAll(arr);
        head = sort(head);
        if(head == null){
            System.out.println("The list cannot be sorted");
        }
        else{
            printAll(head);
        }
    }
}
