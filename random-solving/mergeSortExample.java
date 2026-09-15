import java.util.*;
public class mergeSortExample {
    public static void mergeSort(int[] arr, int high, int low){
        // The condition where the element remaining is the last one that is the size of the array has become 1
        // by breaking down successively
        if(low>=high){
            return;
        }

        // We have the low and the high that we are going to manipulate throught the program
        int mid = (low + high) / 2;
        mergeSort(arr,mid,low);
        mergeSort(arr,high,mid+1);
        merge(arr,low,mid,high);

        
    }
    public static void merge(int[] arr ,int low, int mid, int high){
        //Creating a temporary array to sort the values
        List<Integer> temp = new ArrayList<>();
        // Keep two pointers for the start of each of the arrays
        int leftPointer = low;
        int rightPointer = mid+1;
        while(leftPointer <= mid && rightPointer <= high){
            if(arr[leftPointer] <= arr[rightPointer]){
                temp.add(arr[leftPointer]);
                leftPointer++;
            }
            else{
                temp.add(arr[rightPointer]);
                rightPointer++;
            }    
        }
        // Consider the situation where the rightPointer runs out before the leftPointer
        while(leftPointer <= mid){
            temp.add(arr[leftPointer]);
            leftPointer++;
        }
        // Consider the situation where the leftPointer runs out before the rightPointer
        while(rightPointer <= high){
            temp.add(arr[rightPointer]);
            rightPointer++;
        }

        // Replacing the elements back in place
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("Before swapping: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        int high = n-1, low = 0;
        mergeSort(arr,high, low);
        System.out.println("\nAfter swapping: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
