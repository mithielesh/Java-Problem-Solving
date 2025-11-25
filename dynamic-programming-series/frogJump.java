import java.util.*;
public class frogJump {
    public static int tabJumpOpt(int n, int[] height){
        if(n <= 1) return n;
        int prev = 0;
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int oneJump = prev + Math.abs(height[i] = height[i-1]);
            int twoJumps = Integer.MAX_VALUE;
            if(i  > 1){
                twoJumps = prev2 + Math.abs(height[i] - height[i-2]);
            }
            prev2 = prev;
            prev = Math.min(oneJump, twoJumps);
        }
        return prev;
    }
    public static int tabJump(int n, int[] height){
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int oneJump = dp[i-1] + (int)Math.abs(height[i] - height[i-1]);
            int twoJumps = Integer.MAX_VALUE;
            if(i > 1){
                twoJumps = dp[i-2] + (int)Math.abs(height[i] - height[i-2]);
            }
            dp[i] = (int)Math.min(oneJump, twoJumps);
        }
        return dp[n-1];
    }
    public static int jump(int n, int[] height, int[] dp){
        //First set up the base case
        if(n == 0){
            return 0; // It doesnt take any energy to move from 0 to 0
        }
        // Returned the memoized value if we have one
        if(dp[n] != -1){
            return dp[n];
        }
        int oneJump = Integer.MAX_VALUE, twoJumps = Integer.MAX_VALUE;
        oneJump = jump(n-1,height,dp) + (int)Math.abs(height[n] - height[n-1]); // find the difference between them that is the energy
        if(n > 1){
            // Allowing 2 jump only when it is allowed
            twoJumps = jump(n-2,height,dp) + (int)Math.abs(height[n] - height[n-2]);
        }
        return dp[n] = (int)Math.min(oneJump, twoJumps);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0;i<n;i++){
            height[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int energy = jump(n-1,height,dp);
        int energy2 = tabJump(n,height);
        System.out.println("The minimum energy spent is: "+energy+" "+energy2);
        sc.close();
    }
}
