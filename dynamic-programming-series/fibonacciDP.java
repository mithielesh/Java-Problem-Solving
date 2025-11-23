import java.util.*;
public class fibonacciDP {
    public static int tabFib(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int tabFibOptimal(int n){
        int dp0 = 0;
        int dp1 = 1;
        // Initializing
        int dp2 = 0;
        for(int i=2;i<=n;i++){
            dp2 = dp1 + dp0;
            int temp = dp1;
            dp1 = dp2;
            dp0 = temp;
        }
        return dp2;
    }
    public static int fib(int n, int[] dp){
        // Keep the base case as it is 
        if(n <= 1){
            return n;
        }
        // Say that if the value stored in the dp array is not -1 then it has already been memoized
        if(dp[n] != -1){
            return dp[n];
        }
        // If not then call the recursion but store the value so that it can be memoized for the future
        return dp[n] = fib(n-1,dp) + fib(n-2,dp);
    }
    public static int f(int n){
        if(n<=1){
            return n;
        }
        return f(n-1) + f(n-2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int ans = f(n);
        int[] dp = new int[n+1];
        int ans1 = tabFib(n,dp);
        int ans2 = tabFibOptimal(n);
        System.out.println(ans1+" "+ans2);
        Arrays.fill(dp,-1);
        int val = fib(n,dp);
        System.out.println(val);
        // System.out.println(ans);
        sc.close();
    }
}
