import java.util.Scanner;
public class sudokuXSolver {
    public static void solveSudokuX(char[][] board){
        solve(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean solve(char[][] board){
        // Checking element by element
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c] == '.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValid(board,r,c,ch)){
                            board[r][c] = ch;
                            if(solve(board)){
                                return true;
                            }else{
                                board[r][c] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int r, int c, char ch){
        for(int i=0;i<9;i++){
            // Checking along the row
            if(board[r][i] == ch){
                return false;
            }
            // Checking along the column
            if(board[i][c] == ch){
                return false;
            }
            // Checking the submatrix
            if(board[3*(r/3)+i/3][3*(c/3)+i%3] == ch){
                return false;
            }
        }
        // Doing the checks for the diagonals
        // Along the left main diagonal
        if(r == c){ 
            int i = 0;
            int j = 0;
            while(i < 9 && j < 9){
                if(board[i][j] == ch){
                    return false;
                }
                i++;
                j++;
            }
        }
        // Along the right diagonal
        if(r+c == 8){
            int i = 0;
            int j = 8;
            while(i < 9 && j >= 0){
                if(board[i][j] == ch){
                    return false;
                }
                i++;
                j--;
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
        solveSudokuX(board);
        sc.close();
    }
}
