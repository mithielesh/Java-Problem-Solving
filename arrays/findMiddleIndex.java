import java.util.*;

public class findMiddleIndex {
    private static int middleIndex(int[] arr){
        int totalSum = 0;
        for(int i = 0; i < arr.length; i++){
            totalSum += arr[i];
        }
        int runningSum = 0;
        for(int i = 0; i < arr.length; i++){
            int value = arr[i];
            totalSum -= value;
            if(runningSum == totalSum) return i;
            runningSum += value;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int index = middleIndex(arr);
        System.out.println(index);
        sc.close();
    }
}
