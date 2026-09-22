public class lexicographicNumber {
    List<Integer> list;
    public List<Integer> lexicalOrder(int n) {
        list = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            if(i <= n) {
                list.add(i);
                helper(i*10, n);
            }
            else {
                break;
            }
        }
        return list;
    }
    private void helper(int i, int n) {
        if(i > n) {
            return;
        }
        for(int j = 0; j <= 9; j++) {
            int val = i + j;
            if(val <= n) {
                list.add(val);
                helper(val*10, n);
            }
            else {
                break;
            }
        }
    }
}