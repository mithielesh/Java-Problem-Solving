import java.util.*;

public class secondFrequent {
    public static int secondMostFrequentElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int secondMax = 0;
        for(int i = 0; i < nums.length; i++){
            int tempVal = nums[i];
            if(map.containsKey(tempVal)){
                int count = map.get(tempVal) + 1;
                map.put(tempVal,count);
            }
            else{
                map.put(tempVal,1);
            }
        }

        for(int val : map.values()){
            if(val > max){
                secondMax = max;
                max = val;
            }
            else if(val > secondMax && val < max){
                secondMax = val;
            }
        }
        // There exists no second max then return -1
        if(secondMax == 0) return -1;

        int ans = Integer.MAX_VALUE;
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(val == secondMax){
                if(key < ans){
                    ans = key;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int secondMostFrequent = secondMostFrequentElement(nums);
        System.out.println("The second most frequent element is: "+secondMostFrequent);
        sc.close();
    }
}
