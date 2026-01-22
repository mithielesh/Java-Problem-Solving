import java.util.*;

public class coinChangeProb {
    public static int coinChange(int[] coins, int amount) {
        // Using the pick and not pick but the elements can be repeated
        if(amount == 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int maxVal = amount + 1;
        int numberOfCoins = helper(coins,amount,0,dp,maxVal);
        if(numberOfCoins >= maxVal) return -1;
        return numberOfCoins;
    }
    public static int helper(int[] coins, int amount, int index, int[][] dp, int maxVal){
        if(amount == 0){
            return 0;
        }
        else if(amount < 0 || index == coins.length){
            return maxVal;
        }
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        // Pick strategy
        int pick = helper(coins, amount - coins[index], index, dp, maxVal);
        if(pick != maxVal){
            pick++;
        }

        // Not pick strategy
        int notPick = helper(coins, amount, index + 1, dp, maxVal);
        return dp[index][amount] = Math.min(pick,notPick);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        int count = coinChange(coins, amount);
        System.out.println(count);
        sc.close();
    }
}
