import java.util.*;
public class recur07 {
    public static void printPerm(int[] arr, int n, List<List<Integer>> ans, int index){
        if(index == n){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(list);
            return;
        }

        for(int i=index;i<n;i++){
            // Swap the particular position with every position that comes after it including itself
            swap(i,index,arr);
            // Similarly do it for all the subsequent indices
            printPerm(arr,n,ans,index+1);
            // Backtrack and change it by reswapping before proceeding further
            swap(i,index,arr);
        }
    }
    public static void swap(int i, int index, int[] arr){
        // Does the swapping process
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> ans = new ArrayList<>();
        printPerm(arr,n,ans,0);
        System.out.println("The permutations are: ");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
