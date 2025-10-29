// Descending order in merge and quick sort
import java.util.*;
public class recur02 {

    // Merge sort for the descending order
    public static void mS(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mS(arr,low,mid);
        mS(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr, int low, int mid, int high){
        List <Integer> temp = new ArrayList<>();
        int left = low; 
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] > arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        // Taking care of the right limit hitting
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        // Cosidering we hit the limit of the left
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        // Putting them in place
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i - low);
        }
    }

    // Quick sort in descending order
    public static void qS(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int pIndex = partition(arr,low,high);
        qS(arr,low,pIndex-1);
        qS(arr,pIndex+1,high);
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(arr[i] > pivot && i < high){
                i++;
            }
            while(arr[j] <= pivot && j > low){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = pivot;
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the arrays: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];
        System.out.println("Enter the elements of the first array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the elements of the second array: ");
        for(int i=0;i<n;i++){
            brr[i] = sc.nextInt();
        }
        mS(arr,0,n-1);
        qS(brr,0,n-1);
        arrayPrinter(arr,n,"Merge");
        arrayPrinter(brr,n,"Quick");
        sc.close();
    }
    public static void arrayPrinter(int[] arr, int n, String sorterName){
        System.out.printf("\nThe array sorted using %s is: ",sorterName);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
