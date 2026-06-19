import java.util.*;

public class stock2 {
    private static int buyAndSellStocks(int[] stocks) {
        int n = stocks.length;
        int[][] dp = new int[n+1][0];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return stockProcess(0, 1, stocks, n, dp);
    }
    private static int stockProcess(int ind, int buy, int[] stocks, int n, int[][] dp) {
        if(ind == n) {
            return 0;
        }
        if(dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-stocks[ind] + stockProcess(ind+1,0,stocks,n,dp), 
                            stockProcess(ind+1,1,stocks,n,dp));
        } else {
            profit = Math.max(stocks[ind] + stockProcess(ind+1,1,stocks,n,dp), 
                            stockProcess(ind+1,0,stocks,n,dp));
        }
        return dp[ind][buy] = profit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stocks = new int[n];
        for(int i = 0; i < n; i++) {
            stocks[i] = sc.nextInt();
        }
        int profit = buyAndSellStocks(stocks);
        System.out.println("The profit is: "+profit);
        sc.close();
    }
}
