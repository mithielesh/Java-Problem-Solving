import java.util.*;
public class recur01 {
    public static void combinationSum(int[] arr, int index, List<Integer> list, int target){
        // Base case specification
        if(target==0){
            // Printing the list in the case where it is true
            System.out.println(list);
            return;
        }else if(index == arr.length){
            // If sum not reached but the possibilities explored return 
            return;
        }
        
        // we need to check the taking or not taking of the next index just to check if the sum can reach the target or not
        if(target >= arr[index]){
            list.add(arr[index]);
            target -= arr[index];
            combinationSum(arr,index,list,target);
            target += arr[index];
            list.removeLast();
        }
        combinationSum(arr, index+1, list, target);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        combinationSum(arr,0,list,target);
        sc.close();
    }
}
