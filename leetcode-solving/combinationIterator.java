public class combinationIterator {
    List<String> list;
    int ptr,n;
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        combinator(characters,combinationLength,list,0,sb);
        ptr = 0;
        n = list.size();
    }
    
    private void combinator(String characters, int combinationLength, List<String> list, int index, StringBuilder sb) {
        if(sb.length() == combinationLength) {
            list.add(sb.toString());
            return;
        }
        for(int i = index; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            combinator(characters,combinationLength,list,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String next() {
        String ans =  list.get(ptr);
        ptr++;
        return ans;
    }
    
    public boolean hasNext() {
        return ptr != n;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */