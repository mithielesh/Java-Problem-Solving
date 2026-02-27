import java.util.*;

public class sumEqualToK {
    private static int maxSubarraySize(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == k) len = Math.max(len,i+1);
            if(map.containsKey(sum-k)){
                len = Math.max(len,i - (map.get(sum - k)));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int len = maxSubarraySize(arr,k);
        System.out.println(len);
        sc.close();
    }
}
