import java.util.*;
public class workingParantheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // As soon as a closing bracket is encountered start popping
            if(c != ')'){
                stack.push(c);
            }
            else if(!stack.isEmpty()){
                // If the only elements are the two brackets then it means they wer holding the same thing thus they are duplicated
                if(stack.peek() == '('){
                    return true;
                }
                while(true){
                    // Keep popping until the first opening bracket is encountered
                    char tos = stack.peek();
                    if(tos == '('){
                        stack.pop();
                        break;
                    }
                    stack.pop();
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean ans = isValid(str);
        if(ans) System.out.println("Contains duplicates");
        else System.out.println("Does not contain duplicates");
        sc.close();
    }
}
