import java.util.*;

public class climbingStairs {
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = helper(n,dp);
        return ans;
    }
    public static int helper(int n, int[] dp){
        if(n <= 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = (helper(n-1,dp) + helper(n-2,dp));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int steps = climbStairs(n);
        System.out.println(steps);
        sc.close();
    }
}
