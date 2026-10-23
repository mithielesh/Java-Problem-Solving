class TrieNode {
    int index;
    TrieNode[] letters;
    public TrieNode() {
        this.index = -1;
        this.letters = new TrieNode[27];
    }
}
class WordFilter {
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        int index = 0;
        for(String word : words) {
            updateTrie(word, root, index);
            index++;
        }
    }
    
    public int f(String pref, String suff) {
        // Checking for prefix
        TrieNode curNode = root;
        int ind = -1;
        String s = suff + "{" + pref;
        int n = s.length();
        for(int j = 0; j < n; j++) {
            char c = s.charAt(j);
            if(curNode.letters[c-'a'] == null) {
                return -1;
            }
            curNode = curNode.letters[c-'a'];
            ind = curNode.index;
        }
        return ind;
    }

    private void updateTrie(String word, TrieNode root, int ind) {
        int n = word.length();
        for(int i = 0; i < n; i++) {
            TrieNode curNode = root;
            for(int j = i; j < n; j++) {
                char c = word.charAt(j);
                if(curNode.letters[c-'a'] == null) {
                    curNode.letters[c-'a'] = new TrieNode();
                }
                curNode.index = ind;
                curNode = curNode.letters[c-'a'];
            }
            if(curNode.letters[26] == null) {
                curNode.letters[26] = new TrieNode();
            }
            curNode.index = ind;
            curNode = curNode.letters[26];
            for(int j = 0; j < n; j++) {
                char c = word.charAt(j);
                if(curNode.letters[c-'a'] == null) {
                    curNode.letters[c-'a'] = new TrieNode();
                }
                curNode.index = ind;
                curNode = curNode.letters[c-'a'];
            }
            curNode.index = ind;
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */