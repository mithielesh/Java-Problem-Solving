import java.util.*;

public class maxSumSubset {
    private static int getNum(int[] arr, int target) {
        int[][] dp = new int[arr.length][target+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(arr,target,0,dp);
    }
    private static int helper(int[] arr, int target, int index, int[][] dp) {
        if(target == 0) {
            return 0;
        }
        if(target < 0 || index == arr.length) {
            return -10000;
        }
        if(dp[index][target] != -1) {
            return dp[index][target];
        }
        int pick = helper(arr,target-arr[index],index+1,dp) + 1;
        int notPick = helper(arr,target,index+1,dp);
        return dp[index][target] = Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.print(getNum(arr, target));
        sc.close();
    }
}
