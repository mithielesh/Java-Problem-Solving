import java.util.*;
public class infixToPostfix {
    // Just for commit 12
    public static String converter(String infix){
        StringBuilder post = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<infix.length();i++){
            char c = infix.charAt(i);
            
        }
        return post.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        String postfix = converter(infix);
        System.out.println(postfix);
        sc.close();
    }
}
