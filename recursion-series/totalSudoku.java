import java.util.Scanner;
public class totalSudoku {
    public static void solveTotalSudoku(char[][] board){
        int spaces = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    spaces++;
                }
            }
        }
        int count = solve(board,spaces,0);
        System.out.println("This puzzle has "+count+" combinations");
    }
    public static int solve(char[][] board, int spaces, int index){
        if(index == spaces){
            return 1;
        }
        int count = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            count += solve(board,spaces,index+1);
                            // Backtrack necessary as all the solutions are required
                            board[i][j] = '.';
                            
                        }
                    }
                    return count;
                }
            }
        }
        return count;
    }
    public static boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0;i<9;i++){
            if(board[row][i] == c){
                return false;
            }
            if(board[i][col] == c){
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == c){
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
        solveTotalSudoku(board);
        sc.close();
    }
}
