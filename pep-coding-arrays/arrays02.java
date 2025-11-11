import java.util.*;
public class arrays02 {
    public static int findElement(int[] arr, int n, int target){
        for(int i=0;i<n;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int index = findElement(arr,n,target);
        if(index != -1) System.out.println("The element "+target+" is present at index: "+index);
        else System.out.println("The element does not exist");
        sc.close();
    }
}
