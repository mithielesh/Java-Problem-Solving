import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class floodFillProb {
    public static void floodFill(List<List<Integer>> matrix, int n, int m, int i, int j, int col, int value){
        // Checking for already correct nature
        if(value == col) return;
        // Writing the base case
        if(i < 0 || i >= n || j < 0 || j >= m || matrix.get(i).get(j) != value) return;

        // exploring and filling the same color;
        matrix.get(i).set(j, col);
        floodFill(matrix,n,m,i-1,j,col,value);
        floodFill(matrix,n,m,i+1,j,col,value);
        floodFill(matrix,n,m,i,j-1,col,value);
        floodFill(matrix,n,m,i,j+1,col,value);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = sc.nextInt();
        System.out.println("Enter the elements in the array: ");
        List<List<Integer>> matrix = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<m;j++){
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }
        System.out.println("Enter the starting coordinates: ");
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        System.out.print("Enter the number to change to: ");
        int col = sc.nextInt();
        int value = matrix.get(sx).get(sy);
        floodFill(matrix,n,m,sx,sy,col,value);

        // Printing the array
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
