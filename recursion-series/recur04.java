import java.util.*;
public class recur04{
    public static void combinationSum(int[] arr, int index, List<Integer> list, int target){
        if(target==0){
            System.out.println(list);
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
        
            list.add(arr[i]);
            combinationSum(arr,i+1,list,target - arr[i]);
            list.removeLast();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        combinationSum(arr,0,list,target);
        sc.close();
    }
}