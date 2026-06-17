import java.util.*;
public class stock1 {
    // Can buy and sell stocks only once
    private static int buyAndSellStocks(int[] stocks) {
        int min = Integer.MAX_VALUE, profit = -1;
        for(int stock : stocks) {
            min = Math.min(min,stock);
            profit = Math.max(profit,stock - min);
        }
        return profit;
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