import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean isEndPoint;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndPoint =  false;
    }
}
public class longestCommonPrefix {
    private static void insert(String word, TrieNode root) {
        TrieNode curNode = root;
        for(char letter : word.toCharArray()) {
            int child = letter - 'a';
            if(curNode.children[child] == null) {
                TrieNode node = new TrieNode();
                curNode.children[child] = node;
            }
            curNode = curNode.children[child];
        }
        curNode.isEndPoint = true;
    }
    private static String lcp(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            int len = word.length();
            if(len == 0) {
                return "";
            }
            insert(word,root);
        }
        StringBuilder prefix = new StringBuilder();
        TrieNode curNode = root;
        while(true) {
            int childrenCount = 0;
            int nextDoor = -1;
            for(int i = 0; i < 26; i++) {
                if(curNode.children[i] != null) {
                    childrenCount++;
                    nextDoor = i;
                }
            }
            if(curNode.isEndPoint || childrenCount > 1) {
                break;
            }
            curNode = curNode.children[nextDoor];
            prefix.append((char)('a' + nextDoor));
        }
        return prefix.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.next();
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        System.out.println(lcp(words));
        sc.close();
    }
}
