import java.util.Scanner;

public class validSudoku {
    public static boolean checker(char[][] board){
        int r = board.length;
        int c = board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j] >= 49 && board[i][j] <= 57){
                    if(!isValid(board,i,j,board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col, char c){
        boolean isValid = true;
        board[row][col] = '.';
        for(int i=0;i<9;i++){
            if(board[row][i] == c){
                isValid = false;
                break;
            }
            if(board[i][col] == c){
                isValid = false;
                break;
            }
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c){
                isValid = false;
                break;
            }
        }
        board[row][col] = c;
        return isValid;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        for(int i=0;i<9;i++){
            String temp = sc.next();
            board[i] = temp.toCharArray();
        }
        boolean ans = checker(board);
        if(ans) System.out.println("Valid");
        else System.out.println("Not Valid");
        sc.close();
    }
}
