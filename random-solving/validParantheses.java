import java.util.*;
public class validParantheses{
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else if(!stack.isEmpty()){
                char tos = stack.peek();
                if((tos == '(' && ch == ')') || (tos == '{' && ch == '}') || (tos == '[' && ch == ']')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean ans = isValid(str);
        if(ans) System.out.println("Valid");
        else System.out.println("Not valid");
        sc.close();
    }
}