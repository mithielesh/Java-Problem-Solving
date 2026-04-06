import java.util.*;
public class countAndSay {
    public static String sayAfterCounting(int n){
        if(n == 1) return "1";
        String str = sayAfterCounting(n - 1);
        StringBuilder temp = new StringBuilder(str);
        int count = 1;
        for(int i = 0; i < temp.length()-1; i++){
            if(temp.charAt(i) == temp.charAt(i+1)){
                count++;
            }
            else{

            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = sayAfterCounting(n);
        sc.close();
    }
}
