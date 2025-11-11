import java.util.*;
public class arrays03 {
    public static void barChart(int[] arr, int n){
        int max = findMax(arr,n);
        char[][] pattern = new char[n][max];
        for(int j=0;j<max;j++){
            for(int i=0;i<n;i++){
                int val = max - arr[i];
                if(j>=val){
                    pattern[i][j] = '*';
                }
                else{
                    pattern[i][j] = ' ';
                }
            }
        }
        for(int j=0;j<max;j++){
            for(int i=0;i<n;i++){
                System.out.print(pattern[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int findMax(int[] arr, int n){
        int max = Integer.MIN_VALUE;
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
