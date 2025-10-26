import java.util.*;
public class recur06 {
    public static void subsequence(int index, List<Integer> arr, int n, int[] brr){
        if(index>=n){
            for(int i=0;i<arr.size();i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
            return;
        }

        // Take the element into consideration
        arr.add(brr[index]);
        subsequence(index+1,arr,n,brr);
        arr.removeLast();

        // Do not take the element into consideration
        subsequence(index+1,arr,n,brr);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int index = 0;
        List<Integer> brr = new ArrayList<>();
        System.out.println("The different subsequences are: ");
        subsequence(index,brr,n,arr);
        sc.close();
    }
}
