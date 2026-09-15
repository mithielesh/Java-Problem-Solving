import java.util.Scanner;
public class prob59 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        //Method 1
        System.out.println();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>=j){
                    if(j==0){
                        System.out.print(1+" ");
                        arr[i][j] = 1;
                    }
                    else if(i==j){
                        System.out.print(1+" ");
                        arr[i][j] = 1;
                    }
                    else{
                        int val = arr[i-1][j] + arr[i-1][j-1];
                        System.out.print(val+" ");
                        arr[i][j] = val;
                    }
                }
            }
            System.out.println();
        }

        //Method 2
        /* This pattern follows the rules of combinations it goes from nCk till nCn */
        System.out.println();
        for(int i=0;i<n;i++){
            int icj = 1;
            for(int j=0;j<=i;j++){
                System.out.print(icj+" ");
                int icjp1 = icj * (i-j) / (j+1);
                icj = icjp1;
            }
            System.out.println();
        }
        sc.close();
    }
}
