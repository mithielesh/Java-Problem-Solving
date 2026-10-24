public class findAndReplace {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // Memory inefficient brute force : Check the character mapping at each stage
        int len = pattern.length();
        List<String> matched = new ArrayList<>();
        for(String word : words) {
            char[] map = new char[26];     // every stage new map is created
            boolean[] exists = new boolean[26];   // Check if the val already exists for some other key
            boolean accepted = true;
            for(int i = 0; i < len; i++) {
                char pat = pattern.charAt(i);
                char c = word.charAt(i);
                if(map[pat-'a'] != '\u0000') {
                    if(map[pat-'a'] != c) {
                        accepted = false;
                        break;
                    }
                }
                else {
                    if(exists[c-'a']) {
                        accepted = false;
                        break;
                    }
                    map[pat-'a'] = c;
                    exists[c-'a'] = true;
                }
            }
            if(accepted) {
                matched.add(word);
            }
        }
        return matched;
    }
}