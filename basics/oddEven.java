import java.util.*;
public class oddEven {
    private static long countEvenCombinations(int start,int end,int size){
        long totalNumbers = end - start + 1;
        long evenCount = totalNumbers / 2;
        long oddCount = totalNumbers / 2;

        // If total is odd, one parity appears one extra time.
        // We check the parity of 'start' (or 'end') to decide which one.
        if (totalNumbers % 2 != 0) {
            if (start % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        long[][] dp = new long[size+1][2];
        for(long[] rows : dp){
            Arrays.fill(rows,-1);
        }

        long ans = helper(oddCount,evenCount,size,0,dp,0);
        return ans;
    }
    private static long helper(long oddCount, long evenCount, int size, int index, long[][] dp, int parity){
        long mod = 1000000007;
        if(index == size){
            if(parity == 0){
                return 1;
            }
            return 0;
        }
        if(dp[index][parity] != -1){
            return dp[index][parity];
        }
        long ifEven = (evenCount * helper(oddCount,evenCount,size,index+1,dp,parity)) % mod;
        long ifOdd = (oddCount * helper(oddCount,evenCount,size,index+1,dp,1-parity));
        dp[index][parity] = (ifEven + ifOdd) % mod;
        return dp[index][parity];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int size = sc.nextInt();
        long count = countEvenCombinations(start,end,size);
        System.out.println(count);
        sc.close();
    }
}
