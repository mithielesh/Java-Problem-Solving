import java.util.*;
public class sudokuSolver {
    public static void solveSudoku(char[][] board){
        solve(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean solve(char[][] board){
        // First traverse the array and find the spaces
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                // Check if there is a space
                if(board[i][j] == '0'){
                    for(char ch = '1';ch <= '9'; ch++){
                        if(isValid(board,i,j,ch)){
                            board[i][j] = ch;
                            // If the element is in its expected position then no need to backtrack
                            if(solve(board)){
                                return true;
                            }
                            // Else we need to backtrack
                            else{
                                board[i][j] = '0';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0;i<9;i++){
            // Check if the same element exists in the same row
            if(board[row][i] == c){
                return false;
            }
            // Check if the element exists in the same column
            if(board[i][col] == c){
                return false;
            } 
            // Check if the element exists in its 3x3 sub matrix
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        for(int i=0;i<9;i++){
            String temp = sc.next();
            board[i] = temp.toCharArray();
        }
        solveSudoku(board);
        sc.close();
    }
}
