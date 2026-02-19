import java.util.*;
public class maxSum {
    private static int maximumSum(int[] arr, int k){
        int n = arr.length;
        int sum = 0, maxSum = 0;
        int l = 0, r = 0;
        while(r < n){
            sum += arr[r];
            if(k == 1){
                if(sum > maxSum){
                    maxSum = sum;
                }
                sum -= arr[l];
                l++;
                k++;
            }
            r++;
            k--;
        }
        return maxSum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int sum = maximumSum(arr,k);
        System.out.println(sum);
        sc.close();
    }
}
