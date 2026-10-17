public class findAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int ws = p.length(), n = s.length();
        int[] hashTable = new int[26];
        for(int i = 0; i < ws; i++) {
            hashTable[p.charAt(i)-'a']++;
        }
        int[] runningHash = new int[26];
        int r = 0, l = 0;
        while(r < n) {
            runningHash[s.charAt(r)-'a']++;
            if((r - l + 1) == ws) {
                if(anagramMatcher(hashTable,runningHash)) {
                    ans.add(l);
                }
                runningHash[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
    public boolean anagramMatcher(int[] hashTable1, int[] hashTable2) {
        for(int i = 0; i < 26; i++) {
            if(hashTable1[i] != hashTable2[i]) {
                return false;
            }
        }
        return true;
    }
}