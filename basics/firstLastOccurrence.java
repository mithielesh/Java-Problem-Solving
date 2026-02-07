import java.util.*;
public class firstLastOccurrence {
    public static int[] search(int[] arr, int target){
        int low = 0, high = arr.length - 1;
        int[] index = new int[2];
        Arrays.fill(index,-1);
        int first = -1, last = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if(first == -1){
            return index;
        }
        index[0] = first;
        low = 0;
        high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        index[1] = last;
        return index;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] index = search(arr, target);
        System.out.println(Arrays.toString(index));
        sc.close();
    }
}
