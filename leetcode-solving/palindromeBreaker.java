public class palindromeBreaker {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder(palindrome);
        boolean changed = false, specialCase = false;
        for(int i = 0; i < n; i++) {
            if(sb.charAt(i) > 'a') {
                if(n % 2 == 1 && i == n/2) {
                    specialCase = true;
                    break;
                }
                sb.setCharAt(i,'a');
                changed = true;
                break;
            }
        }
        if(!changed || specialCase) {
            sb.setCharAt(n-1, 'b');
        }
        return sb.toString();
    }
}