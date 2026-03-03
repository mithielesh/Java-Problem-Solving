import java.util.*;
public class validParantheses {
    public static int validParanthesesCount(String str){
        // int leftCount = 0, rightCount = 0;
        // Checking left side and right side
        int open = 0;
        int rightCheck = 0, max = 0;
        // Checking from left to right
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                open++;
            }
            else{
                if(open > 0){
                    rightCheck++;
                    open--;
                }
                if(open == 0){
                    max = Math.max(max,rightCheck);
                    rightCheck = 0;
                }
            }
        }
        int close = 0, leftCheck = 0;
        // Checking from right left
        for(int i = str.length()-1; i >= 0; i--){
            char c = str.charAt(i);
            if(c == ')'){
                close++;
            }
            else{
                if(close > 0){
                    leftCheck++;
                    close--;
                }
                if(close == 0){
                    max = Math.max(max,leftCheck);
                    leftCheck = 0;
                }
            }
        }
        return max * 2;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = validParanthesesCount(str);
        System.out.println(count);
        sc.close();
    }
}
