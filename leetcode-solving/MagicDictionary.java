class TrieNode {
    boolean completed;
    TrieNode[] letters;
    public TrieNode() {
        this.completed = false;
        this.letters = new TrieNode[26];
    }
}
public class MagicDictionary {
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        // Build the entire trie
        for(String word : dictionary) {
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
    
    public boolean search(String searchWord) {
        return checker(root,searchWord,0,0,searchWord.length());
    }

    private boolean checker(TrieNode root, String searchWord, int ind, int mistakes, int n) {
        if(mistakes > 1) {
            return false;
        }
        if(ind == n) {
            if(root.completed && mistakes == 1) {
                return true;
            }
            return false;
        }
        for(char i = 'a'; i <= 'z'; i++) {
            if(root.letters[i-'a'] != null) {
                if(i == searchWord.charAt(ind)) {
                    if(checker(root.letters[i-'a'],searchWord,ind+1,mistakes,n)) {
                        return true;
                    }
                }
                else {
                    if(checker(root.letters[i-'a'],searchWord,ind+1,mistakes+1,n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */