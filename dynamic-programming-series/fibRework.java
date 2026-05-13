import java.util.*;
public class fibRework {
    public static int fibbiest(int n) {
        int a = -1, b = 1;
        for(int i = 0; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    private static int fibbier(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    private static int fibber(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fib(n-1) + fib(n-2);
    }
    private static int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibbiest(n));
        sc.close();
    }
}