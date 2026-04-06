import java.util.*;
public class radixSort {
    public static void sort(int[] arr){
        
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
