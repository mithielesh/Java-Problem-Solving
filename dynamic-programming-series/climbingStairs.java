import java.util.*;
public class climbingStairs {
    public static int jumpStairs(int n){
        // The reason being if we are at 0 we have successfully completed it
        // If we are at 1 then there is only one way to reach the the bottom
        if(n <= 1){
            return 1;
        }
        // We take the top-down approach and try to find out ways to reach the bottom
        int left = jumpStairs(n-1);
        int right = jumpStairs(n-2);
        return left+right;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jump = jumpStairs(n);
        System.out.println(jump);
        sc.close();
    }
}
