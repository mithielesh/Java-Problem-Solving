import java.util.*;
public class selectionSort {
    // Always find the smallest element and swap with the element of the current position if smaller
    public static void sort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int min = Integer.MAX_VALUE;
            int minInd = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minInd = j;
                }
            }
            if(min < arr[i]){
                int temp = arr[i];
                arr[i] = arr[minInd];
                arr[minInd] = temp;
            }
        }
    }
    public static void print(int[] arr){
        System.out.println("The sorted array is:");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sort(arr);
        print(arr);
        sc.close();
    }
}
