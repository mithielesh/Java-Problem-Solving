import java.util.*;
public class maximumNonAdjacentSum {
    public static int tabMNASDPOpt(int[] nums){
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i > 1){
                pick += prev2;
            }
            int notPick = prev;
            prev2 = prev;
            prev = Math.max(pick,notPick);
        }
        return prev;
    }
    public static int tabMNASDP(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i > 1){
                pick += dp[i-2];
            }
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[n-1];
    }
    public static int mNASDP(int[] nums, int[] dp, int n){
        if(n == 0){
            return nums[n];
        }
        if(n < 0){
            return 0;
        }
        // Use the memized value
        if(dp[n] != -1){
            return dp[n];
        }
        int pick = nums[n] + mNASDP(nums,dp,n-2);
        int notPick = mNASDP(nums,dp,n-1);
        // Memoize the value
        return dp[n] = Math.max(pick,notPick);
    }
    public static int maxNonAdjacentSum(int[] nums){
        int ind = nums.length-1;
        int max = recur(ind,nums);
        return max;
    }
    public static int recur(int ind, int[] nums){
        if(ind == 0){
            return nums[0];
        }
        if(ind < 0){
            return 0;
        }
        // Pick the element
        int pick = nums[ind] + recur(ind-2,nums);
        // Not pick the element
        int notPick = recur(ind-1,nums);
        return Math.max(pick,notPick);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int ans = maxNonAdjacentSum(nums);
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans2 = mNASDP(nums,dp,n-1);
        int ans3 = tabMNASDP(nums);
        int ans4 = tabMNASDPOpt(nums);
        System.out.println(ans+" "+ans2+" "+ans3+" "+ans4);
        sc.close();
    }
}
