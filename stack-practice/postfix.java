import java.util.*;

public class postfix {
    public static int evaluate(String[] postfix){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<postfix.length;i++){
            String c = postfix[i];
            if(!c.equals("+") && !c.equals("*") && !c.equals("-") && !c.equals("/")){
                stack.push(Integer.parseInt(c));
            }
            else{
                int b = stack.pop();
                int a = stack.pop();
                int val = 0;
                if(c.equals("*")){
                    val = a * b;
                }
                else if(c.equals("/")){
                    val = a / b;
                }
                else if(c.equals("+")){
                    val = a + b;
                }
                else if(c.equals("-")){
                    val = a - b;
                }
                stack.push(val);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] postfix = new String[n];
        for(int i=0;i<n;i++){
            postfix[i] = sc.next();
        }
        int val = evaluate(postfix);
        System.out.println(val);
        sc.close();
    }    
}
