import java.util.*;
public class squareFreeFactors {
    public static int squareFreeCount(int n){
        int ans = findPrimeFactors(n);
        // minus 1 cause we dont include 1 in the count
        int finalAns = (int)Math.pow(2,ans) - 1;
        return finalAns;
    }
    public static int findPrimeFactors(int n){
        int count = 0;
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0){
                count++;
                while(n % i == 0){
                    n /= i;
                }
            }
        }
        if(n > 1){
            count++;
        }
        return count;
    }
    public static boolean perfectSquare(int n){
        int temp = (int)Math.sqrt(n);
        if((temp*temp) == n)
            return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = squareFreeCount(n);
        System.out.println(count);
        sc.close();
    }
}
