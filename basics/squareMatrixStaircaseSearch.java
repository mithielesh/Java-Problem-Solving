import java.util.*;
public class squareMatrixStaircaseSearch {
    public static boolean searchMatrix(int[][] matrix, int target){
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m-1;
        while(row <= n-1 && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int target = sc.nextInt();
        boolean flag = searchMatrix(matrix,target);
        if(flag) System.out.println("Present");
        else System.out.println("Absent");
        sc.close();
    }
}
