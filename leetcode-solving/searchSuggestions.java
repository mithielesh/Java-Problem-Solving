class TrieNode {
    boolean completed;
    TrieNode[] letters;
    public TrieNode() {
        this.completed = false;
        this.letters = new TrieNode[26];
    }
}
public class searchSuggestions {
    // An attempt with a certain thought
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        triePopulator(root, products);
        List<List<String>> suggestions = new ArrayList<>();
        TrieNode curNode = root;
        int n = searchWord.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c = searchWord.charAt(i);
            if(curNode.letters[c-'a'] == null) {
                while(i < n) {
                    suggestions.add(new ArrayList<>());
                    i++;
                }
                break;
            }
            sb.append(c);
            List<String> suggest = new ArrayList<>();
            curNode = curNode.letters[c-'a'];
            suggester(curNode,suggest,sb);
            suggestions.add(suggest);
        }
        return suggestions;
    }
    private boolean suggester(TrieNode root, List<String> suggest, StringBuilder sb) {
        if(suggest.size() == 3) {
            return true;
        }
        if(root.completed) {
            suggest.add(sb.toString());
            if(suggest.size() == 3) {
                return true;
            }
        }
        for(int i = 0; i < 26; i++) {
            if(root.letters[i] != null) {
                sb.append((char)('a'+i));
                if(suggester(root.letters[i],suggest,sb)) {
                    sb.deleteCharAt(sb.length()-1);
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
    private void triePopulator(TrieNode root, String[] products) {
        for(String product : products) {
            TrieNode curNode = root;
            for(char c : product.toCharArray()) {
                if(curNode.letters[c-'a'] == null) {
                    curNode.letters[c-'a'] = new TrieNode();
                }
                curNode = curNode.letters[c-'a'];
            }
            curNode.completed = true;
        }
    }
}