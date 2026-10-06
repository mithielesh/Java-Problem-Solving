public class validPalindromeII {
    public boolean validPalindrome(String s) {
        int n = s.length()-1, l = 0, r = n;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                if(l == 0 && r == n && (l+1 == r-1)) {
                    return false;
                }
                boolean left = false, right = false;
                if(s.charAt(l+1) == s.charAt(r)) {
                    left = simulator(s,l+1,r);
                }
                if(s.charAt(l) == s.charAt(r-1)) {
                    right = simulator(s,l,r-1);
                }
                return left || right;
            }
            l++; r--;
        }
        return true;
    }
    private boolean simulator(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
}