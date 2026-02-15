import core.Node;
public class palindromeList {
    private static boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            // nothing can be a palindrome with less than 2 elements
            return false;
        }
        Node temp = head;
        Node mid = midPoint(temp);
        Node connect = mid.next;
        Node last = reverse(connect);
        Node first = head;
        while(first != null && last != null){
            if(first.data != last.data){
                return false;
            }
            first = first.next;
            last = last.next;
        }
        return true;
    }
    // Second helper function
    private static Node reverse(Node head){
        Node prev = null;
        Node cur = head;
        while(cur != null){
            Node front = cur.next;
            cur.next = prev;
            prev = cur;
            cur = front;
        }
        return prev;
    }
    // First helper function
    private static Node midPoint(Node head){
        // Use the tortoise and hear to find the mid point
        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next != null){
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
        int[] arr = {1,2,3,4,5};
        Node head = convertAll(arr);
        boolean flag = isPalindrome(head);
        System.out.println(flag);
    }
}
