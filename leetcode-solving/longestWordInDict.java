class TrieNode {
    boolean completed;
    TrieNode[] letters;
    public TrieNode() {
        this.completed = false;
        this.letters = new TrieNode[26];
    }
}
public class longestWordInDict {
    TrieNode root;
    String[] ans;
    public String longestWord(String[] words) {
        root = new TrieNode();
        StringBuilder sb = new StringBuilder();
        dictionarySetup(words,root);
        ans = new String[1];
        ans[0] = "";
        search(root,sb);
        return ans[0];
    }
    private void search(TrieNode root, StringBuilder sb) {
        for(int i = 0; i < 26; i++) {
            if(root.letters[i] != null && root.letters[i].completed) {
                sb.append((char)(i+'a'));
                search(root.letters[i],sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        if(sb.length() > ans[0].length()) {
            ans[0] = sb.toString();
        }
        else if(sb.length() == ans[0].length() && ans[0].compareTo(sb.toString()) > 0) {
            ans[0] = sb.toString();
        }
    }
    private void dictionarySetup(String[] words, TrieNode root) {
        for(String word : words) {
            TrieNode curNode = root;
            for(char c : word.toCharArray()) {
                if(curNode.letters[c-'a'] == null) {
                    curNode.letters[c-'a'] = new TrieNode();
                }
                curNode = curNode.letters[c-'a'];
            }
            curNode.completed = true;
        }
    }
}