import java.util.*;

public class nextGreatestElement {
    public static int greatestScore(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        int max = 0;
        int finMax = 0;
        for(int i=n-1;i>=0;i--) {
            if(arr[i] > max) {
                max = arr[i];
            }
            temp[i] = max - arr[i];
            if(temp[i] > finMax) {
                finMax = temp[i];
            }
        }
        return finMax;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int max = greatestScore(arr);
        if(max == 0){
            System.out.println("UNFIT");
        }
        else{
            System.out.println(max);
        }
        sc.close();
    }  
}
