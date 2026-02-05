import java.util.*;
public class diagonalTraversal {
    public static int[] findDiagonalOrder(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] ans = new int[n*m];

        int r = 0, c = 0;
        for(int i = 0 ;i < n * m; i++){
            ans[i] = matrix[r][c];
            if((r+c) % 2 == 0){
                if(c == m-1){
                    r++;
                }
                else if(r == 0){
                    c++;
                }
                else{
                    r--;
                    c++;
                }
            }
            else{
                if(r == n-1){
                    c++;
                }
                else if(c == 0){
                    r++;
                }
                else{
                    r++;
                    c--;
                }
            }
        }   
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] ans = findDiagonalOrder(matrix);
        for(int i = 0; i < m * n; i++){
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }
}
