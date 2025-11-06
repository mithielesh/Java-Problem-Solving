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
    Node root;
    public BinarySearchTree(){
        this.root = null;
    }

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
}
public class binarySearchTreeProb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
}
