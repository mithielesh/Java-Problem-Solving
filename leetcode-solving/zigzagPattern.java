public class zigzagPattern {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int interval = (2 * numRows) - 2, n = s.length(), diag = interval;

        for(int i = 0; i < numRows; i++) {
            int ind = i;
            while(ind < n) {
                sb.append(s.charAt(ind));
                if(i > 0 && i < (numRows-1) && (ind + diag) < n) {
                    sb.append(s.charAt(ind + diag));
                }
                ind += interval;
            }
            diag -=2;
        } 
        return sb.toString();
    }
}
