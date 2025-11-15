import java.util.*;
public class prePlacedQueens {
    public static void nQueens(char[][] board){
        int n = board.length;
        List<List<String>> ans = new ArrayList<>();
        prePlacedSolver(ans,board,n,0);
        if(ans.size() == 0){
            System.out.println("There is no possible answer for this");
        }else{
            for(int i=0;i<ans.size();i++){
                System.out.println("The board is: ");
                List<String> temp = ans.get(i);
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        System.out.print(temp.get(j).charAt(k)+" ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
    public static void prePlacedSolver(List<List<String>> ans, char[][] board, int n, int col){
        if(col == n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                String temp = new String(board[i]);
                list.add(temp);
            }
            ans.add(list);
            return;
        }
        int r = isPrePlaced(board,col,n);
        if(r == -1){
            for(int row=0;row<n;row++){
                if(isValid(board,col,row,n)){
                    board[row][col] = 'Q';
                    prePlacedSolver(ans,board,n,col+1);
                    board[row][col] = '.';
                }
            }
        }else{
            if(isValid(board,col,r,n)){
                prePlacedSolver(ans,board,n,col+1);
            }else{
                return;
            }
        }
    }
    public static int isPrePlaced(char[][] board, int col, int n){
        // this checks if the row already contains a queen
        for(int r=0;r<n;r++){
            if(board[r][col] == 'Q'){
                return r;
            }
        }
        return -1;
    }
    public static boolean isValid(char[][] board, int col, int row, int n){
        // Checking the entire row for the presence of queen
        for(int i=0;i<n;i++){
            if(i != col && board[row][i] == 'Q'){
                return false;
            }
        }
        // Checking the top-left part
        int r = row-1;
        int c = col-1;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }
        // Checking the bottom-left part
        r = row+1;
        c = col-1;
        while(r < n && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r++;
            c--;
        }
        // Checking the top-right part
        r = row-1;
        c = col+1;
        while(r >= 0 && c < n){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c++;
        }
        // Checking the bottom-right part
        r = row+1;
        c = col+1;
        while(r < n && c < n){
            if(board[r][c] == 'Q'){
                return false;
            }
            r++;
            c++;
        }
        // If all the checks pass return true
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board: ");
        int n = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[n][n];
        System.out.println("Enter the element: ");
        for(int i=0;i<n;i++){
            String row = sc.next();
            board[i] = row.toCharArray();
        }
        nQueens(board);
        sc.close();
    }
}
