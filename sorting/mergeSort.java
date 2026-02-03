import java.util.*;

public class mergeSort {
    public static void sort(int[] arr){
        int l = 0, r = arr.length-1;
        mS(arr,l,r);
    }
    private static void mS(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mS(arr,low,mid);
        mS(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private static void merge(int[] arr, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int i = low;
        int j = mid+1;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                j++;
            }
        }
        while(i <= mid){
            temp.add(arr[i]);
            i++;
        }
        while(j <= high){
            temp.add(arr[j]);
            j++;
        }
        for(int ind = low; ind <= high; ind++){
            arr[ind] = temp.get(ind-low);
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
