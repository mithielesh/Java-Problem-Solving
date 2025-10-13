import java.util.Scanner;
public class prob63{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        for(int m : arr){
            int num = Math.abs(m);
            if(arr[num-1]>0){
                arr[num-1] = arr[num-1] * -1;
            }
            else{
                System.out.println(Math.abs(m));
                return;
            }
        }
        System.out.println("No duplicate");
    }
}