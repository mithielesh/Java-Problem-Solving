public class scoreOfParantheses {
    public int scoreOfParentheses(String s) {
        int score = 0, open = 0;
        // Since it has been mentioned that it is a perfectly balanced string
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                int count = open - 1;
                while(s.charAt(i) == '(') {
                    open++;
                    count++;
                    i++;
                }
                i--;
                score += Math.pow(2, count);
            }
            else {
                open--;
            }
        }
        return score;
    }
}