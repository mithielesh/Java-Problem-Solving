import java.util.*;
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class BinarySearchTree{
    static Node root;
    public void insert(int val){
        root = insertRec(root,val);
    }
    public Node insertRec(Node currentNode, int val){
        if(currentNode == null){
            Node newNode = new Node(val);
            return newNode;
        }

        if(val < currentNode.value){
            currentNode.left = insertRec(currentNode.left,val);
        }
        else if(val > currentNode.value){
            currentNode.right = insertRec(currentNode.right,val);
        }
        return currentNode;
    }
    
    public static void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            System.out.println();
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.print(currentNode.value+" ");
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        System.out.println();
    }
}
public class binarySearchTreeProb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
}
