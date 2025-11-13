import java.util.*;
public class recur03 {
    public static void subsetSum(int[] arr, List<Integer> ans, int index, int n, int sum){
        if(index == n){
            ans.add(sum);
            return;
        }
        // Picking the element
        sum += arr[index];
        subsetSum(arr,ans,index+1,n,sum);
        sum -= arr[index];

        // Not picking the element
        subsetSum(arr,ans,index+1,n,sum);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> ans = new ArrayList<>();
        subsetSum(arr,ans,0,n,0);
        Collections.sort(ans);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
