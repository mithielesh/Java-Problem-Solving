import java.util.*;
public class overlappingIntervals {
    public static int overlap(int[] arr){
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int intervals = overlap(arr);
        System.out.println("The number of intervals are: "+intervals);
        sc.close();
    }
}
