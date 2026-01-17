import java.util.*;
public class minMaxFreqSum {
    public static int sumHighestAndLowestFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int tempVal = nums[i];
            if(map.containsKey(tempVal)){
                int count = map.get(tempVal) + 1;
                map.put(tempVal, count);
            }
            else{
                map.put(tempVal,1);
            }
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int val : map.values()){
            if(val > max){
                max = val;
            }
            if(val < min){
                min = val;
            }
        }
        return max + min;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int ans = sumHighestAndLowestFrequency(nums);
        System.out.println("The sum of the highest and lowest frequency values is: "+ans);
        sc.close();
    }
}
