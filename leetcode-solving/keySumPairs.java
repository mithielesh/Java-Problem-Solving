class TrieNode {
    int score;
    TrieNode[] letters;
    public TrieNode() {
        this.score = 0;
        this.letters = new TrieNode[26];
    }
}
public class keySumPairs {
    TrieNode root;
    HashMap<String,Integer> map = new HashMap<>();
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        if(map.containsKey(key)) {
            update(key,val,map.get(key));
            map.replace(key,val);
            return;
        }
        map.put(key,val);
        TrieNode curNode = root;
        int n = key.length();
        for(int i = 0; i < n; i++) {
            char c = key.charAt(i);
            if(curNode.letters[c-'a'] == null) {
                curNode.letters[c-'a'] = new TrieNode();
            }
            curNode.letters[c-'a'].score += val;
            curNode = curNode.letters[c-'a'];
        }
    }

    private void update(String key, int val, int oldVal) {
        TrieNode curNode = root;
        int n = key.length();
        for(int i = 0; i < n; i++) {
            char c = key.charAt(i);
            curNode.letters[c-'a'].score -= oldVal;
            curNode.letters[c-'a'].score += val;
            curNode = curNode.letters[c-'a'];
        }
    }   
    
    public int sum(String prefix) {
        int n = prefix.length(), ans = 0;
        TrieNode curNode = root;
        for(int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if(curNode.letters[c-'a'] == null) {
                return 0;
            }
            ans = curNode.letters[c-'a'].score;
            curNode = curNode.letters[c-'a'];
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */