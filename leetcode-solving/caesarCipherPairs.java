class Solution {
    public long countPairs(String[] words) {
        int n = words.length, m = words[0].length();
        if(n == 1) {
            return 0;
        }
        HashMap<String,Integer> cipherMap = new HashMap<>();
        cipherMap.put(words[0],1);
        char cipher = words[0].charAt(0);
        for(int i = 1; i < n; i++) {
            String word = words[i];
            char[] letters = word.toCharArray();
            int increaser = 0;
            if(letters[0] <= cipher) {
                increaser = cipher - letters[0];
            }
            else {
                increaser = ('z' - letters[0]) + (cipher - 'a') + 1;
            }
            letters[0] = cipher;
            for(int j = 1; j < m; j++) {
                int val = letters[j] + increaser;
                if(val <= 122) {
                    letters[j] = (char)(letters[j] + increaser);
                }
                else {
                    int diff = increaser - ('z' - letters[j]);
                    letters[j] = (char)('a' + diff - 1);
                }
            }
            cipherMap.put(String.valueOf(letters), cipherMap.getOrDefault(String.valueOf(letters),0)+1);
        }
        long count = 0;
        for(int val : cipherMap.values()) {
            count += ((long)val * (long)(val-1)) / 2;
        }
        return count;
    }
}