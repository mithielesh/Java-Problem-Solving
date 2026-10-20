public class minRemoveValidParantheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int openCount = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '(') {
                openCount++;
            }
            else if(sb.charAt(i) == ')') {
                openCount--;
            }
            if(openCount < 0) {
                sb.deleteCharAt(i);
                i--;
                openCount++;
            }
        }
        int index = sb.length()-1;
        while(openCount != 0) {
            if(sb.charAt(index) == '(') {
                sb.deleteCharAt(index);
                openCount--;
            }
            index--;
        }
        return sb.toString();
    }
}