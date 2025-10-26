import java.util.*;
public class recur03 {
    public static void reverse(int l,int r,int[] arr){
        if(l>=r){
            return;
        }
        // Can also use Collections.swap(a,l,r); But it only works for ArrayLists
        swap(l,r,arr);
        reverse(l+1,r-1,arr);
    }
    public static void swap(int l, int r, int[] arr){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The array is: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        reverse(0,n-1,arr);
        System.out.println("\nThe reversed array is: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
