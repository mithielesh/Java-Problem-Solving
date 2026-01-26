import java.util.*;
public class printUnsorted {
    public static List<Integer> getUnsortedSubarray(int[] arr){
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int right = n-1, left = 0;
        // Find the left breaking point
        for(int i = 0; i < n; i++){
            if(i > 0){
                if(arr[i] < arr[i-1]){
                    left--;
                    break;
                }
            }
            left++;
        }
        // Find the right breaking point
        for(int i = n-1; i >= 0; i--){
            if(arr[i] < arr[i-1]){
                break;
            }
            right--;
        }
        if(left > right) return ans;
        // Now find the max and the min value in the subarray
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        // Now we start the check towards the boundary to check for the edge values
        // First for the left
        for(int i = 0; i <= left; i++){
            if(arr[i] > min){
                left = i;
                break;
            }
        }
        // Now we are checking for the right boundary
        for(int i = n-1; i >= right; i--){
            if(arr[i] < max){
                right = i;
                break;
            }
        }
        ans.add(left);
        ans.add(right);
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> ans = getUnsortedSubarray(arr);
        System.out.println(ans);
        sc.close();
    }
}
