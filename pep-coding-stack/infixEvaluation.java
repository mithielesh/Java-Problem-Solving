import java.util.*;
/*
Rules:
    1. We are taking an assumption that the values of the operands will be only from 0 - 9
    2. The only operators used here will be  * + - /
    3. If we get an operand push it into the operand stack
    4. If we get an operator then the rules are
        4.1. If we get an opening bracket push into the operators stack
        4.2. If we get a closing bracket, pop and peform all the actions till the opening bracket. Pop the opening bracket and push the final answer
        4.3. Operators of precedence pop all those equal to or less than them, not greater than them
 */

public class infixEvaluation {
    public static int evaluate(String infix){
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();
        boolean open = false;
        int ans = 0;
        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);
            if(ch >= '0' && ch <= '9'){
                operands.push((int)ch - '0');
            }
            else{
                // if()
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        int ans = evaluate(infix);
        System.out.println(ans);
        sc.close();
    }    
}
