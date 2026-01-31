import java.util.*;
public class primeFactorisation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queries = new int[n];
        for(int i = 0;i < n; i++){
            queries[i] = sc.nextInt();
        }
        sc.close();
    }
}
