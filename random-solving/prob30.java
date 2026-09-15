import java.util.Scanner;
public class prob30 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] arr = new String[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.next();
            }
        }
        int k = sc.nextInt();
        int count=0;
        int i=0,j=0;
        for(i=0;i<n;){
            for(j=0;j<n;j++){
                for(int l=0;l<k;l++){
                    System.out.print(arr[i][j]+" ");
                }
            }
            count++;
            if(count%k==0){
                i++;
            }
            System.out.println();
        }
        sc.close();
    }
}
