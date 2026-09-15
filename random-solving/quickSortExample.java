import java.util.*;
public class quickSortExample {
    public static void quickSort(List<Integer> arr, int low, int high){
        // the base case is when we reach one element, because 1 element is always sorted
        if(low >= high ){
            return;
        }
        int partition = partitioning(arr,low,high);
        quickSort(arr,low,partition-1);
        quickSort(arr,partition+1,high);
    }
    public static int partitioning(List<Integer> arr, int low, int high){
        int pivot = arr.get(low);
        int i = low;
        int j = high;
        while(i < j){
            while((arr.get(i) <= pivot) && i < high){
                i++;
            }
            while((arr.get(j) > pivot) && j > low){
                j--;
            }
            if(i < j){
                Collections.swap(arr,i,j);
            }
        }
        Collections.swap(arr,j,low);
        return j;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        int high = n-1, low=0;
        quickSort(list,low,high);
        System.out.println("The sorted array is: ");
        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
        sc.close();
    }
}
