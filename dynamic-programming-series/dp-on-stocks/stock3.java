import java.util.*;
public class stock3 {
    private static int buyAndSellStocks(int[] stocks) {
        
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
