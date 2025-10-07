import java.util.Scanner;
public class prob45 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        // Initialization
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j%i==0){
                    if(arr[j-1]==0){
                        arr[j-1] = 1;
                    }
                    else{
                        arr[j-1] = 0;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
