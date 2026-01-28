import java.util.*;
public class arrayManipulation {
    public static int manipulate(int n, int[][] queries){
        // Brute Force
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < queries.length; i++){
            int startInd = queries[i][0] - 1;
            int endInd = queries[i][1] - 1;
            int val = queries[i][2];
            for(int j = startInd; j <= endInd; j++){
                arr[j] += val;
                if(arr[j] > max){
                    max = arr[j];
                }
            }
        }
        return max;
    }
    
    public static long manipulateFast(int n, int[][] queries){
        // Optimized version
        long[] arr = new long[n+2];
        for(int[] query : queries){
            int i = query[0];
            int j = query[1];
            int val = query[2];
            arr[i] += val;
            arr[j+1] -= val;
        }
        long max = Long.MAX_VALUE;
        for(int i = 1; i < n+2; i++){
            arr[i] += arr[i-1];
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        sc.close();
    }
}
