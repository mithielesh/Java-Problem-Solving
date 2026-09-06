public class addSpacesToString {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int spcPtr = 0, n = s.length() ,m = spaces.length;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(spcPtr < m && spaces[spcPtr] == i) {
                sb.append(" ");
                spcPtr++;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public String addSpacesII(String s, int[] spaces) {
        int n = s.length(), m = spaces.length, j = 0, index = 0;
        char[] ans = new char[s.length() + spaces.length];
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(j < m && spaces[j] == i) {
                ans[index] = ' ';
                j++;
                index++;
            }
            ans[index] = c;
            index++;
        }
        return String.valueOf(ans);
    }

}