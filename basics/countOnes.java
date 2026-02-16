import java.util.*;
public class countOnes {
    private static int counter(int n){
        // Can just use Integer.bitSet(value) inside the loop to do in TC -> O(n)
        if(n == 0 || n == 1) return n;
        int count = 1;
        for(int i = 2; i <= n; i++){
            int num = i;
            while(num != 1){
                if(num % 2 == 1) count++;
                num /= 2;
            }
            count++;
        }
        return count;
    }
    private static int counterOpt(int n){
        int[] dp = new int[n+1];
        int oneCount = 0;
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i >> 1] + (i & 1);
            oneCount += dp[i];
        }
        return oneCount;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = counterOpt(n);
        System.out.println(count);
        sc.close();
    }
}
