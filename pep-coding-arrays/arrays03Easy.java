import java.util.*;
public class arrays03Easy {
    public static void barChart(int[] arr, int n){
        int max = findMax(arr,n);
        for(int i=max;i>0;i--){
            for(int j=0;j<n;j++){
                if(arr[j] >= i){
                    System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    public static int findMax(int[] arr, int n){
        int max = 0;
        for(int i=0;i<n;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        barChart(arr,n);
        sc.close();
    }
}
