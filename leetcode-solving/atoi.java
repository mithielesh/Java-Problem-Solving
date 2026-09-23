public class atoi {
    public int myAtoi(String s) {
        String str = s.trim();
        int result = 0;
        boolean num = false, neg = false, sign = false;
        int limit = Integer.MAX_VALUE / 10; 
        for(char c : str.toCharArray()) {
            // Related to the limits
            if(result > limit && (c >= '0' && c <= '9')) {
                if(neg) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            else if(result == limit) {
                // Need to do an extra check here
                if(neg && c >= '8') {
                    return Integer.MIN_VALUE;
                }
                if(!neg && c > '7') {
                    return Integer.MAX_VALUE;
                }
            }
            // Related to the string
            if(c == '-' && !num && !sign) {
                neg = true;
                sign = true;
            }
            else if(c == '+' && !num && !sign) {
                sign = true;
                continue;
            }
            else if(c >= '0' && c <= '9') {
                result = (result * 10) + (c-'0');
                num = true;
            }
            else {
                break;
            }
        }
        if(neg) {
            result = 0 - result;
        }
        return result;
    }
}
