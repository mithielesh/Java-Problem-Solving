import java.util.*;
public class validParantheses {
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            // Only if the stack is not empty do we even eccept the closing parantheses
            else if(!stack.isEmpty()){
                char tos = stack.peek();
                if(c == '}' && tos == '{' ||
                c == ')' && tos == '(' ||
                c == ']' && tos == '['){
                    stack.pop();
                }
                else{
                    // If the current element and the tos are not forming a valid combination like 
                    // {} or () or [] then return false
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean ans = isValid(str);
        if(ans) System.out.println("Valid");
        else System.out.println("Not Valid");
        sc.close();
    }
}
