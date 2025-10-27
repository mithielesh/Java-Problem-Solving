import java.util.*;
public class recur08 {
    public static boolean recur(List<Integer> arr, int[] brr, int index, int n, int sum, int sumCheck){
        if(index == n){
            if(sumCheck == sum){
                System.out.println(arr);
                return true;
            }
            return false;
        }
         // the case where we are picking something
        sumCheck += brr[index];
        arr.add(brr[index]);
        if(recur(arr,brr,index+1,n,sum,sumCheck) == true) return true;
        // removing it to check other alternatives
        sumCheck -= brr[index];
        arr.removeLast();

        // this is the case where we are not taking anything
        if(recur(arr, brr, index+1, n, sum, sumCheck) == true) return true;

        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] brr = new int[n];
        for(int i=0;i<n;i++){
            brr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        boolean flag = recur(list, brr, index, n, sum,0);
        sc.close();
    }
}
