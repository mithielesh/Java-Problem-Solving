import java.util.*;
public class countInversions {
    public static int count(int[] arr){
        int inversions = mS(arr,0,arr.length-1);
        System.out.println("The sorted array is:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
        return inversions;
    }
    public static int mS(int[] arr, int low, int high){
        if(low >= high){
            return 0;
        }
        int mid = (low + high) / 2;
        int rightCount = mS(arr,low,mid);
        int leftCount = mS(arr,mid+1,high);
        int crossCount = merge(arr,low,mid,high);
        return rightCount + leftCount + crossCount;
    }
    public static int merge(int[] arr, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int i = low;
        int j = mid+1;
        int count = 0;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                count += mid - i + 1;
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
        for(int k=low;k<=high;k++){
            arr[k] = temp.get(k - low);
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int invert = count(arr);
        System.out.println("The number of inversions is: "+invert);
        sc.close();
    }
}
