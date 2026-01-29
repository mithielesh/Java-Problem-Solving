import java.util.*;
public class moveZerosToEnd {
    public static void movingZeros(int[] arr){
        int n = arr.length;
        int read = 0, write = 0;
        int index = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                read++;
            }
            else{
                index++;
                arr[write] = arr[read];
                write++;
                read++;
            }
        }
        for(int i = index; i < n; i++){
            arr[i] = 0;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        movingZeros(arr);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
