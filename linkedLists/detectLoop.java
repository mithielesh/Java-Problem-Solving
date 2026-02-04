import core.Node;
public class detectLoop {
    private static boolean loopFinder(Node head){
        if(head == null || head.next == null){
            return false;
        }
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
    private static Node loop(Node head, int pos){
        if(pos != -1){
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            Node loop = head;
            while(pos != 1){
                loop = loop.next;
                pos--;
            }
            temp.next = loop;
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
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int pos = 5;
        Node head = convertAll(arr);
        loop(head,pos);
        boolean flag = loopFinder(head);
        System.out.println(flag);
    }
}
