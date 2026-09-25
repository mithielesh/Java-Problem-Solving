public class romanToInteger {
    public int romanToInt(String s) {
        /*
        NOTE:
            only rules to remember
            I can be placed before V (5) and X (10) to make 4 and 9. 
            X can be placed before L (50) and C (100) to make 40 and 90. 
            C can be placed before D (500) and M (1000) to make 400 and 900.
         */

        int n = s.length();
        int val = 0;
        for(int i = n-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I':
                    val += 1;
                    break;
                case 'V':
                    if(reducerCheck(i,s,'I')) {
                        val += 4;
                        i--;
                    }
                    else {
                        val += 5;
                    }
                    break;
                case 'X':
                    if(reducerCheck(i,s,'I')) {
                        val += 9;
                        i--;
                    }
                    else {
                        val += 10;
                    }
                    break;
                case 'L':
                    if(reducerCheck(i,s,'X')) {
                        val += 40;
                        i--;
                    }
                    else {
                        val += 50;
                    }
                    break;
                case 'C':
                    if(reducerCheck(i,s,'X')) {
                        val += 90;
                        i--;
                    }
                    else {
                        val += 100;
                    }
                    break;
                case 'D':
                    if(reducerCheck(i,s,'C')) {
                        val += 400;
                        i--;
                    }
                    else {
                        val += 500;
                    }
                    break;
                case 'M':
                    if(reducerCheck(i,s,'C')) {
                        val += 900;
                        i--;
                    }
                    else {
                        val += 1000;
                    }
                    break;
                default:
                    break;
            }
        }
        return val;
    }
    private boolean reducerCheck(int i, String s, char num) {
        return (i > 0 && s.charAt(i-1) == num);
    }
}