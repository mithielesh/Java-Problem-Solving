import java.util.*;
public class recur07 {
    public static void sum(int n, List<Integer> brr, int[] arr, int k, int index){
        if(index == n){
            int sum = 0;
            for(int i=0;i<brr.size();i++){
                sum += brr.get(i);
            }
            if(sum==k){
                System.out.println(brr);
            }
            return;
        }
        // Take the element into consideration
        brr.add(arr[index]);
        sum(n,brr,arr,k,index+1);
        brr.removeLast();

        // Not to take the last element into consideration
        sum(n,brr,arr,k,index+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        List<Integer> brr = new ArrayList<>();
        sum(n,brr,arr,k,0);
    }
}
