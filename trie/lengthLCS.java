import java.util.*;
// Attempt at making a trie for a number suffix matcher

class TrieNode {
    TrieNode[] children;
    boolean isEndPoint;

    publix TrieNode() {
        this.children = new TrieNode[10];
        this.isEndPoint = false;
    }
}
public class lengthLCS {
    private static int lcpLen(int[] nums) {
        TrieNode root = new TrieNode();
        for(int num : nums) {
            insert(num, root);
        }
        TrieNode curNode = root;
        int length = 0;
        while(true) {
            int childrenCount = 0;
            int nextDoor = -1;
            for(int i = 0; i < 10; i++) {
                if(curNode.children[i] != null) {
                    childrenCount++;
                    nextDoor = i;
                }
            }
            if(curNode.isEndPoint || childrenCount != 1) {
                break;
            }
            curNode = curNode.children[nextDoor];
            length++;
        }
        return length;
    }
    private static void insert(int num, TrieNode root) {
        // numbers are pass by value so not an issue
        TrieNode curNode = root;
        while(num != 0) {
            int last = num % 10;    
            if(curNode.children[last] == null) {
                TrieNode node = new TrieNode;
                curNode.children[last] = node;
            }
            curNode = curNode.children[last];
            num /= 10;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(lcpLen(arr));
        sc.close();
    }
}