import java.util.Scanner;
public class prob57 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] arr = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==0 || j==0){
                    arr[i][j] = 1;
                }
                else{
                    int sum = arr[i-1][j] + arr[i][j-1];
                    arr[i][j] = sum;
                }
            }
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Total number of ways to reach it: "+arr[size-1][size-1]);
        sc.close();
    }
}
