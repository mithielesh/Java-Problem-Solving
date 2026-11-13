public class labelPartitioning {
    public List<Integer> partitionLabels(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen,-1);
        int n = s.length();
        for(int i = n-1; i>= 0; i--) {
            char c = s.charAt(i);
            if(lastSeen[c-'a'] == -1) {
                lastSeen[c-'a'] = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean[] hashTable = new boolean[26];
        int ind = 0, start = 0, end = 0;
        while(ind < n) {
            char c = s.charAt(ind);
            if(!hashTable[c-'a']) {
                int lastInd = lastSeen[c-'a'];
                if(lastInd > end) {
                    end = lastInd;
                }
                hashTable[c-'a'] = true;
            }
            if(ind == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
            ind++;
        }
        return list;
    }
}