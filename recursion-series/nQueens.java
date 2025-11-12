import java.util.*;
public class nQueens {
    public static void queens(char[][] board, int n, int index){
        if(index == n){
            System.out.println("\nThe board is:");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        for(int row=0; row<n; row++){
            if(isSafe(board,n,index,row)){
                board[row][index] = 'Q';
                queens(board,n,index+1);
                board[row][index] = '.';
            }
        }
    }
    public static boolean isSafe(char[][] board, int n, int index, int row){
        // Checking if it lies along the same row as another queen
        for(int i=index; i>=0; i--){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        // Checking the upward diagonal
        int j = index;
        int i = row;
        while(i>=0 && j>=0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }

        // Checking the lower diagonals
        j = index;
        i = row;
        while(i<n && j>=0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the board size: ");
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = '.';
            }
        }
        queens(arr,n,0);
        sc.close();
    }
}
