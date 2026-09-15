import java.util.*;
public class maxGenNumber {
    public static int getMaximumGenerated(int n) {
        if(n <= 1){
            return n;
        }
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        int limit = n/2;
        for(int i=1;i<=limit;i++){
            nums[2*i] = nums[i];
            if((2*i)+1 <= n){
                nums[(2*i)+1] = nums[i] + nums[i+1];
            }
        }
        int max = 0;
        for(int num : nums){
            System.out.print(num+" ");
            if(num > max){
                max = num;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = getMaximumGenerated(n);
        System.out.print("\n"+ans);
        sc.close();
    }
}