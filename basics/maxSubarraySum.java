import java.util.*;
// Need to avoid the adjacent elements
public class maxSubarraySum {
    public static int getMaxSubarraySum(int[] arr){
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        int count = helper(arr,dp,0);
        return count;
    }
    public static int helper(int[] arr, int[] dp, int index){
        if(index >= arr.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
         
        // Let us use the pick and not pick
        int pick = arr[index] + helper(arr,dp,index+2);

        // now for the not pick
        int notPick = helper(arr,dp,index+1);
        return dp[index] = Math.max(pick,notPick);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int maxSum = getMaxSubarraySum(arr);
        System.out.println(maxSum);
        sc.close();
    }
}
