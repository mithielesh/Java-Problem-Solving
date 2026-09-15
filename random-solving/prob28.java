import java.util.Scanner;
public class prob28 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        for(int i=0;i<n;i++){
            if(i<n-1){
                sum += arr[i]+arr[i+1];
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
