import java.util.*;
public class frogJumpKDist {
    public static int tabJumpK(int n, int[] heights, int k){
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(j <= i){
                    int val = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    if(val < min){
                        min = val;
                    }
                }
                else{
                    break;
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
    public static int jumpKDP(int n, int[] heights, int k, int[] dp){
        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(i <= n){
                int val = jumpKDP(n-i,heights,k,dp) + Math.abs(heights[n] - heights[n-i]);
                if(val < min){
                    min = val;
                }
            }
        }
        return dp[n] = min;
    }
    public static int jumpK(int n, int[] heights, int k){
        if(n == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(i <= n){
                int val = jumpK(n-i,heights,k) + Math.abs(heights[n] - heights[n-i]);
                if(val < min){
                    min = val;
                }
            }
        }
        return min;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans1 = jumpKDP(n-1,heights,k,dp);
        int ans2 = jumpK(n-1,heights,k);
        int ans3 = tabJumpK(n,heights,k);
        System.out.println(ans1+" "+ans2+" "+ans3);
        sc.close();
    }
}
