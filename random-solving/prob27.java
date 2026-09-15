import java.util.Scanner;
public class prob27 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];
        int[] val = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            brr[i] = sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(brr[j]>brr[j+1]){
                    int temp = brr[j];
                    brr[j] = brr[j+1];
                    brr[j+1] = temp;
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            val[i] = arr[i]*brr[i];
            System.out.print(val[i]+" ");
            sum += val[i];
        }
        System.out.println();
        System.out.println(sum);
        sc.close();
    }
}
