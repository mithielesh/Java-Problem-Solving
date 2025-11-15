import java.util.Scanner;
public class nSudokuSolver {
    public static void solveNSudoku(int[][] board, int n){
        solve(board,n);
        System.out.println("\nThe board is: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean solve(int[][] board, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 0){
                    for(int c=1;c<=n;c++){
                        if(isValid(board,i,j,n,c)){
                            board[i][j] = c;
                            if(solve(board,n)){
                                return true;
                            }
                            else{
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(int[][] board, int row, int col, int n, int c){
        int m = (int)Math.sqrt(n);
        for(int i=0;i<n;i++){
            if(board[row][i] == c){
                return false;
            }
            if(board[i][col] == c){
                return false;
            }
            if(board[m*(row/m)+i/m][m*(col/m)+i%m] == c){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // In order to handle the limitiations of ASCII characters being just 0-9 the need to use integer array arises
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }
        solveNSudoku(board,n);
        sc.close();
    }
}
