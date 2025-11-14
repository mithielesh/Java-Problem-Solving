import java.util.*;
public class permutation2 {
    public static List<List<Integer>> permuteCombinations(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        permute(ans,nums,0);
        return ans;
    }
    public static void permute(List<List<Integer>> ans, int[] nums, int index){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }
        // Use a set to check for duplicates, helps after the order is changed which is the case the sorting
        HashSet<Integer> set = new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            swap(i,index,nums);
            permute(ans,nums,index+1);
            swap(i,index,nums);
        }
    }
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> ans = permuteCombinations(nums);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
