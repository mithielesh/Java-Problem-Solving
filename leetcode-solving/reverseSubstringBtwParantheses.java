public class reverseSubstringBtwParantheses {
    public String reverseParentheses(String s) {
        // This will be a brute force solution using 2 stacks 
        int n = s.length();
        char[] stack = new char[n];
        char[] supportStack = new char[n];
        StringBuilder sb = new StringBuilder();
        int tos = 0, toss = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c != ')') {
                stack[tos] = c;
                tos++;
            }
            else {
                tos--;
                while(stack[tos] != '(') {
                    supportStack[toss] = stack[tos];
                    toss++; tos--;
                }
                if(tos != 0) {
                    for(int j = 0; j < toss; j++) {
                        stack[tos] = supportStack[j];
                        tos++;
                    }
                }
                else {
                    for(int j = 0; j < toss; j++) {
                        sb.append(supportStack[j]);
                    }
                }
                toss = 0;
            }
        }
        int ind = 0;
        while(ind < tos) {
            if(stack[ind] >= 'a' && stack[ind] <= 'z') {
                sb.append(stack[ind]);
            }
            ind++;
        }
        return sb.toString();
    }
}