import java.util.*;
public class LongestCommonPrefix {
    // public static String LCPOpt1(String[] str){
    //     // This takes the approach of progressively comparing every other value to reduce the number of checks
    //     int n = str.length;
        
    // }
    // public static String LCPOpt2(String[] str){
    //     // This goes with the approach of sorting and then comparing the last values
    //     int n = str.length;
    // }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = sc.next();
        }
        // String ans1 = LCPOpt1(str);
        // String ans2 = LCPOpt2(str);
        // System.out.println("The answer is: "+ans1+" "+ans2);
        sc.close();
    }
}
