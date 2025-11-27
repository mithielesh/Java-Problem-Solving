import java.util.*;
public class houseRobber {
    public static int tabRobOpt(int[] houses, int n){
        int prev = houses[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = houses[i];
            if(i > 1){
                pick += prev2;
            }
            int notPick = prev;
            int curi = Math.max(pick,notPick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    public static int tabRob(int[] houses,int[] dp, int n){
        dp[0] = houses[0];
        for(int i=1;i<n;i++){
            int pick = houses[i];
            if(i > 1){
                pick += dp[i-2];
            }
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
    public static int roberry(int[] houses){
        int n = houses.length;
        int[] dp = new int[n-1];
        Arrays.fill(dp,-1);
        int[] houses1 = new int[n-1];
        int[] houses2 = new int[n-1];
        for(int i=0;i<n;i++){
            if(i != 0){
                houses1[i-1] = houses[i];
            } 
            if(i != n-1){
                houses2[i] = houses[i];
            }
        }
        int ans1 = rob(houses1,dp,n);
        int ans2 = rob(houses2,dp,n);
        return Math.max(ans1,ans2);
    }
    public static int rob(int[] houses, int[] dp, int ind){
        if(ind == 0){
            return houses[0];
        }
        if(ind < 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = houses[ind] + rob(houses,dp,ind-2);
        int notPick = rob(houses,dp,ind-1);
        return dp[ind] = Math.max(pick, notPick);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] houses = new int[n];
        for(int i=0;i<n;i++){
            houses[i] = sc.nextInt();
        }
        int ans = roberry(houses);
        System.out.println(ans);
        sc.close();
    }
}
