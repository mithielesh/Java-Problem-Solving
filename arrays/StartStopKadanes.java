import java.util.*;
public class StartStopKadanes {
    // public static int[] SSK(int[] arr){
    //     int n =  arr.length;
    //     int[] ans = new int[2];
    //     int curSum = 0;
    //     int globalSum = Integer.MIN_VALUE;
    //     int start = 0, stop = 0;
    //     for(int i = 0; i < n; i++){
            
    //     }
    //     return ans;
    // }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        // int[] ans = SSK(arr);
        // System.out.println("Start: "+ans[0]+"\nEnd: "+ans[1]);
        sc.close();
    }
}
