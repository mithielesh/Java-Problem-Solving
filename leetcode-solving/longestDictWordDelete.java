public class longestDictWordDelete {
    public String findLongestWord(String s, List<String> words) {
        words.sort((s1, s2) -> {
            int lenCompare = Integer.compare(s2.length(), s1.length());
            if (lenCompare != 0) {
                return lenCompare; // Longest first
            }
            return s1.compareTo(s2); // Alphabetical tie-breaker
        });
        int len =s.length();
        for(String word : words) {
            int p1 = 0, p2 = 0, n = word.length();
            boolean found = true;
            while(p1 < n) {
                while(p2 < len && word.charAt(p1) != s.charAt(p2)) {
                    p2++;
                }
                if(p2 == len) {
                    found = false;
                    break;
                }
                p1++; p2++;
            }
            if(found) {
                return word;
            }
        }
        return "";
    }
}