import core.Node;
public class removingElements {
    // Practice for removing the head
    private static Node removeHead(Node head){
        if(head == null) return head;
        // Need not free the space for the old head as there is garbage collection in java
        head = head.next;
        return head;
    }
    // Removing the tail
    private static Node removeTail(Node head){
        if(head == null) return head;
        if(head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    // Remove the kth element
    private static Node removeKthElement(Node head, int index){
        if(head == null) return head;
        if(index == 1){
            head = head.next;
            return head;
        }
        Node cur = head, bef = null;
        int count = 0;
        while(cur != null){
            count++;
            if(count == index){
                bef.next = cur.next;
                break;
            }
            bef = cur;
            cur = cur.next;
        }
        return head;
    }
    // Remove x value
    private static Node removeX(Node head, int x){
        if(head == null) return head;
        if(head.data == x){
            head = head.next;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == x){
                prev.next = temp.next;
                break;
            }
            prev = temp;
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
        int[] arr = {10,2,3,4,5};
        Node head = convertAll(arr);
        // head = removeTail(head);
        head = removeX(head,10);
        printAll(head);
        // System.out.print(head.data);
    }
}
