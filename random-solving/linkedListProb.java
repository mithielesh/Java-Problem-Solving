public class linkedListProb {
    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // We are setting up the head that will point to the start of the linked list
    private Node head;
    public linkedListProb(){
        this.head = null;
    }

    // Setting up the function to add the first element
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    // Setting up the element to add at the last place
    public void addLast(int data){
        Node newNode = new Node(data);
        newNode.next = null;
        if(head == null){
            this.head = newNode;
            return;
        }
        Node temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Writing the remove duplicates method
    // It assumes that the values are always entered in ascending or descending order
    public void removeDuplicates(){
        if(this.head == null){
            return;
        }
        Node temp1 = this.head;
        Node temp2 = this.head;
        while(temp1.next != null){
            if(temp2 == null){
                temp1.next = null;
                continue;
            }
            else if(temp2.data != temp1.data){
                temp1.next = temp2;
                temp1 = temp2;
            }
            temp2 = temp2.next;
        }
    }

    // Delete the first element
    public void delete(int val){
        if(this.head == null){
            System.out.println("The list is empty");
            return;
        }
        else if(head.data == val){
            this.head = this.head.next;
            return;
        }
        else{
            Node temp = this.head;
            while(temp.next != null){
                if(temp.next.data == val){
                    temp.next = temp.next.next;
                    return;
                }
                else{
                    temp = temp.next;
                }
            }
        }
        System.out.println("The element is not there in the array");
    }

    // Displaying the elements
    public void display(){
        if(this.head == null){
            System.out.println("The list is empty.");
            return;
        }
        Node temp = this.head;
        System.out.println("The elements are:");
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        linkedListProb list = new linkedListProb();
        list.display();
        list.addFirst(10);
        list.display();
    }
}
