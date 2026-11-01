import java.util.*;
public class printTillN {
    // Using the sieve of eratosthenes we do
    public static int findPrimesSoE(int n){
        int[] primes = new int[n+1];
        arraySetter(primes);
        int count = 0;
        for(int i = 2; i < primes.length; i++){
            if(primes[i] == 1){
                count++;
            }
        }
        return count;
    }
    public static void arraySetter(int[] primes){
        for(int i = 2; i < primes.length; i++){
            primes[i] = 1;
        }
        int n = primes.length - 1;
        // Now is the main process we call it the prime harmonic sequence
        for(int i = 2; i*i <= n; i++){
            if(primes[i] == 1){
                for(int j = i*i; j <= n; j+=i){
                    primes[j] = 0;
                }
            }
        }
    }


    // Brute force takes O(n^3/2) that is O(n * n^1/2);
    public static List<Integer> findPrimesTillN(int n){
        List<Integer> ans = new ArrayList<>();
        if(n <= 1) return ans;
        for(int i = 2; i <= n; i++){
            if(n == 2){
                ans.add(2);
            }
            else{
                boolean flag = true;
                for(int j = 2; j*j <= i; j++){
                    if(i % j == 0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans.add(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findPrimesSoE(n));
        sc.close();
    }
}
