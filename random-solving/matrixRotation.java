import java.util.*;
public class matrixRotation {
    public static void rotate(int[][] mat){
        int n = mat.length;
        int layers = n/2;
        int top = 0, left = 0, bottom = n-1, right = n-1;
        int sLimit = 0, eLimit = n-1; 
        int temp1 = 0, temp2 = 0;
        for(int i=0;i<layers;i++){
            for(int j=sLimit; j<eLimit; j++){
                temp1 = mat[bottom][j];
                mat[bottom][j] = mat[j][left];
                temp2 = mat[n-j-1][right];
                mat[n-j-1][right] = temp1;
                temp1 = mat[top][n-j-1];
                mat[top][n-j-1] = temp2;
                mat[j][left] = temp1;
            }
            top++;
            left++;
            bottom--;
            right--;
            sLimit++;
            eLimit--;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        rotate(mat);
        System.out.println("The rotated matrix is: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
