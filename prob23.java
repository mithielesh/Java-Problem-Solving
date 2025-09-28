import java.util.Scanner;
//import java.io.*;
public class prob23 {
    public static void main(String[] argv){
        // int i,j,m;
        // int[][] a = new int[10][10];
        // int[][] b = new int[10][10];
        // int[][] c = new int[10][10];
        // Scanner sc = new Scanner(System.in);
        // m = sc.nextInt();
        // for(i=0;i<m;i++){
        //     for(j=0;j<m;j++){
        //         a[i][j] = sc.nextInt();
        //     }
        // }
        // for(i=0;i<m;i++){
        //     for(j=0;j<m;j++){
        //         b[i][j] = sc.nextInt();
        //     }
        // }
        // System.out.println("The sum of the 2 matrices are: ");
        // for(i=0;i<m;i++){
        //     for(j=0;j<m;j++){
        //         c[i][j] = a[i][j] + b[i][j];
        //         System.out.print(c[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        Scanner sc = new Scanner(System.in);
        int m,n;
        int[][] a = new int[10][10];
        int[][] b = new int[10][10];
        System.out.println("Enter the number of rows: ");
        m = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        n = sc.nextInt();
        System.out.println("Enter the elements of the matrix: ");
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                b[j][i] = a[i][j];
            }
        }
        System.out.println("The transpose of the matrix is: ");
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        // for(int i=0;i<m;i++){
        //     int max = a[i][0];
        //     for(int j =0;j<n;j++){
        //         if(a[i][j]>max){
        //             max = a[i][j];
        //         }
        //         System.out.printf("The max element of row  %d is %d",i,max);
        //         System.out.println();
        //     }
        //};
        sc.close();
    }
}
