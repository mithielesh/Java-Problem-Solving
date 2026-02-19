import java.util.*;

public class sumLessThanK {
    private static int subarraySize(int[] arr, int k){
        int n = arr.length;
        int r = 0, l = 0;
        int sum = 0, maxLen = n;
        while(r < n){
            sum += arr[r];
            while(sum > k){
                sum -= arr[l];
                l++;
            }
            if(sum <= k){
                maxLen = Math.max(maxLen,r - l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int sum = subarraySize(arr,k);
        System.out.println(sum);
        sc.close();
    }
}
