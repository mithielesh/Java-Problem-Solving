import java.util.*;
public class mergeAndQuickPracSort {

    // This is for the merge sort practice
    public static void mergeSort(int[] arr, int low, int high){

        // Reached the smallest state
        if(low >= high){
            return;
        }

        // Find the breaking point, that is the mid point
        int mid = (low + high) / 2;
        // Call for the left subarray to divide first
        mergeSort(arr, low, mid);
        // After all the left subarray calls complete it will backtrack to this call for right subarray
        mergeSort(arr, mid+1, high);
        // After getting the smallest elements we can then divide them
        merge(arr, low, mid, high);
    }
    
    public static void merge(int[] arr, int low, int mid, int high){
        List <Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        // Cosidering the case where the right hit the limit first
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        // Considering the case where the left hit the limit first
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        // Setting the elements back in place
        for(int i=low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
    }

    // This is for the quick sort
    public static void quickSort(int[] arr, int low, int high){
        // codition where the last singular elemnt is found
        if(low >= high){
            return;
        }

        // Find the pivot's correct position that is the point of partition
        int partition = part(arr,low,high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition+1, high);
    }

    public static int part(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        
        // this is for the traversing of the pointers
        while(i < j){

            // trying to find the elements that are smaller than the pivot element
            while((arr[i] <= pivot) && i < high){   // the range of the i needs to specified to prevent it moving out of range
                i++;
            }
            
            // trying to find the elements that are bigger than the pivot element
            while((arr[j] > pivot) && j > low){
                j--;
            }
            if(i < j){
                // Swapping the smaller element with the larger elements so that they can be together
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swapping the pivot in its position as it should be in the sorted array
        int temp = arr[j];
        arr[j] = pivot;
        arr[low] = temp;

        // returning the partition index
        return j;
    }


    // the main function that is used to get the input and print the output
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the row: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println();
        System.out.print("The elements before sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        // Call the merge sort function
        mergeSort(arr,0,n-1);
        System.out.print("\nThe elements after sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }



        System.out.print("\nEnter the number of elements in the row: ");
        int m = sc.nextInt();
        int[] brr = new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<m;i++){
            brr[i] = sc.nextInt();
        }
        System.out.println();
        System.out.print("The elements before sorting: ");
        for(int i=0;i<m;i++){
            System.out.print(brr[i]+" ");
        }

        // Call the quick sort
        quickSort(brr,0,m-1);
        System.out.print("\nThe elements after sorting: ");
        for(int i=0;i<m;i++){
            System.out.print(brr[i]+" ");
        }
        sc.close();
    }
}
