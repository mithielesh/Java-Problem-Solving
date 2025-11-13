import java.util.*;
public class countingNQueens {
    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int count = queens(board,n,0);
        return count;
    }
    public static int queens(char[][] board, int n, int col) {
        if(col == n){
            return 1;
        }
        int count = 0;
        for(int row=0; row<n; row++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';
                count += queens(board, n, col+1);
                board[row][col] = '.';
            }
        }
        return count;
    }
    public static boolean isSafe(char[][] board, int row, int col, int n){
        for(int i=col; i>=0; i--){
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        int c = col;
        int r = row;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }
        r = row; 
        c = col;
        while(r < n && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r++;
            c--;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the board size: ");
        int n = sc.nextInt();
        int count = totalNQueens(n);
        System.out.println("The total unique "+n+" queen combinations are: "+count);
        sc.close();
    }
}
