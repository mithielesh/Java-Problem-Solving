import java.util.*;
public class Kadanes {
    public static int kadanesAlgorithm(int[] arr){
        int n = arr.length;
        int curMax = 0;
        // this is for the case that all the values are negative
        int globalMax = Integer.MIN_VALUE;;

        for(int i=0;i<n;i++){
            // If the value is not less than 0 then add it
            if(curMax >= 0){
                curMax += arr[i];
            }
            // otherwise use the value itself
            else{
                curMax = arr[i];
            }
            // then compare all values. Only if it is greater then substitute or let it be the same
            if(curMax >= globalMax){
                globalMax = curMax;
            }
        }
        return globalMax;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int max = kadanesAlgorithm(arr);
        System.out.println("The max is: "+max);
        sc.close();
    }
}
