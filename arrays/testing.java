import java.util.*;

public class testing {
    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            while((num != i+1) && (num >= 1 && num <= n)) {
                if(num == nums[num-1]) {
                    break;
                }
                int temp = nums[num-1];
                nums[num-1] = num;
                nums[i] = temp;
                num = temp;
            }
        }
        int miss = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] != i+1) {
                miss = i+1;
                break;
            }
        }
        return (miss == -1) ? n+1 : miss;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(firstMissingPositive(arr));
        sc.close();
    }    
}
