import java.util.*;
public class bracketRev {
    public static int reversals(String bracs){
        int open = 0, close = 0;
        for(int i = 0; i < bracs.length(); i++){
            char brac = bracs.charAt(i);
            if(brac == '('){
                open++;
            }
            else{
                if(open > 0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        int ans = 0;
        while(open > 1){
            ans++;
            open -= 2;
        }
        while(close > 1){
            ans++;
            close -= 2;
        }
        if(open == 0 && close == 0) return ans;
        if(open == 1 && close == 1) return ans+2;
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String bracs = sc.next();
        int count = reversals(bracs);
        System.out.println(count);
        sc.close();
    }
}
