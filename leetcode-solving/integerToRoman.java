public class integerToRoman {
    public String intToRoman(int num) {
        int temp = num, pow = 1;
        StringBuilder sb = new StringBuilder();
        /*
            There are 2 options:
                - Insert all the stringlets in the 0th position (Every insertion will cause shifting)
                - Insert the roman numerals in reverse order and just reverse the string
            Choosing option 2
        */
        while(temp != 0) {
            int digit = temp % 10;
            if(digit == 4) {
                if(pow == 1) {
                    sb.append("VI");
                }
                else if(pow == 10) {
                    sb.append("LX");
                }
                else if(pow == 100) {
                    sb.append("DC");
                }
            }
            else if(digit == 9) {
                if(pow == 1) {
                    sb.append("XI");
                }
                else if(pow == 10) {
                    sb.append("CX");
                }
                else if(pow == 100) {
                    sb.append("MC");
                }
            }
            else {
                if(pow == 1) {
                    adder(sb, digit, 'I', 'V');
                }
                else if(pow == 10) {
                    adder(sb, digit, 'X', 'L');
                }
                else if(pow == 100) {
                    adder(sb, digit, 'C', 'D');
                }
                else {
                    while(digit != 0) {
                        sb.append('M');
                        digit--;
                    }
                }
            }
            pow *= 10;
            temp /= 10;
        }
        return sb.reverse().toString();
    }
    private void adder(StringBuilder sb, int digit, char a, char b) {
        if(digit < 5) {
            while(digit != 0) {
                sb.append(a);
                digit--;
            }
        }
        else if(digit == 5) {
            sb.append(b);
        }
        else {
            while(digit != 5) {
                sb.append(a);
                digit--;
            }
            sb.append(b);
        }
    }
}