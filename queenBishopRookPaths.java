import java.util.*;
public class queenBishopRookPaths {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row size: ");
        int row = sc.nextInt();
        System.out.print("Enter the column size: ");
        int col = sc.nextInt();
        char[][] queenBoard = new char[row][col];
        char[][] bishopBoard = new char[row][col];
        char[][] rookBoard = new char[row][col];
        char[][] finalBoard = new char[row][col];
        
        // initialize the two piece boards
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                queenBoard[i][j] = '-';
                bishopBoard[i][j] = '-';
                rookBoard[i][j] = '-';
            }
        }

        // Setting up the queen board
        System.out.println("Enter the queen's coordinates: ");
        int qRow= sc.nextInt();
        int qCol = sc.nextInt();
        //Setting up the queen
        queenBoard[qRow][qCol] = 'Q';
        // Setting up the straight movements of the queen
        calculatingStraights(queenBoard, row, col, qRow, qCol, '$');
        // Setting up the diagonal movements of the queen
        calculatingDiagonals(queenBoard, row, col, qRow, qCol, '$');

        // Setting up the bishop position
        System.out.println("Enter the bishop's coordinates: ");
        int bRow = sc.nextInt();
        int bCol = sc.nextInt();
        //Set the position of the bishop
        bishopBoard[bRow][bCol] = 'B';
        //Setting up the diagonal movements of the bishop
       calculatingDiagonals(bishopBoard, row, col, bRow, bCol, '*');

       // Setting up the bishop position
        System.out.println("Enter the rook's coordinates: ");
        int rRow = sc.nextInt();
        int rCol = sc.nextInt();
        //Set the position of the bishop
        rookBoard[rRow][rCol] = 'R';
        // Setting up the straight movements of the rook
        calculatingStraights(rookBoard, row, col, rRow, rCol, '^');

        /*  Calculating the final board, the constraints being that the Queen and the Bishop  and the Rook will never be in the same position
        and if the path is traversed by all the queen and the bishop and the rook then the symbol there becomes %
        */
        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                if(queenBoard[i][k] == '$' && bishopBoard[i][k] == '*' && rookBoard[i][k] == '^'){
                    finalBoard[i][k] = '%';
                }
                else if(queenBoard[i][k] == '$' && bishopBoard[i][k] == '*'){
                    finalBoard[i][k] = '+'; 
                }
                else if(queenBoard[i][k] == '$' && rookBoard[i][k] == '^'){
                    finalBoard[i][k] = '?'; 
                }
                else if(bishopBoard[i][k] == '*' && rookBoard[i][k] == '^'){
                    finalBoard[i][k] = '!';
                }
                else if(queenBoard[i][k] == 'Q'){
                    finalBoard[i][k] = 'Q'; 
                }
                else if(bishopBoard[i][k] == 'B'){
                    finalBoard[i][k] = 'B';
                }
                else if(rookBoard[i][k] == 'R'){
                    finalBoard[i][k] = 'R';
                }
                else if(queenBoard[i][k] == '$'){
                    finalBoard[i][k] = '$';
                }
                else if(bishopBoard[i][k] == '*'){
                    finalBoard[i][k] = '*';
                }
                else if(rookBoard[i][k] == '^'){
                    finalBoard[i][k] = '^';
                }
                else{
                    finalBoard[i][k] = '-';
                }
            }
        }

        // Printing the queenboard
        printBoard(queenBoard, row, col, "Queen");

        // Printing the bishopboard
        printBoard(bishopBoard, row, col, "Bishop");

        // Printing the rookboard
        printBoard(rookBoard, row, col, "Rook");

        // Printing the finalboard
        printBoard(finalBoard, row, col, "Final");

        sc.close();
    }
    public static void calculatingStraights(char[][] board, int row, int col, int pieceRow, int pieceCol, char ch){
        // Along the row
        for(int i=0; i<col;i++){
            if(i != pieceCol)
                board[pieceRow][i] = ch;
        }
        // Along the column
        for(int i=0;i<row;i++){
            if(i != pieceRow){
                board[i][pieceCol] = ch;
            }
        } 
    }
    public static void calculatingDiagonals(char[][] board, int row, int col, int pieceRow, int pieceCol, char ch){
        int j=0;
        // Top left quadrant
        j = pieceRow;
        for(int i=pieceCol;i>=0;i--){
            if(i != pieceCol){
                if(j >= 0){
                    board[j][i] = ch;
                }else{
                    break;
                }
            }
            j--;
        }
        // Top right quadrant
        j = pieceRow;
        for(int i=pieceCol;i<col;i++){
            if(i != pieceCol){
                if(j >= 0){
                    board[j][i] = ch;
                }
                else{
                    break;
                }
            }
            j--;
        }
        // Bottom left quadrant
        j = pieceRow;
        for(int i=pieceCol;i>=0;i--){
            if(i != pieceCol){
                if(j<row){
                    board[j][i] = ch;
                }
                else{
                    break;
                }
            }
            j++;
        }
        // Bottom Right quadrant
        j = pieceRow;
        for(int i=pieceCol;i<col;i++){
            if(i != pieceCol){
                if(j<row){
                    board[j][i] = ch;
                }
                else{
                    break;
                }
            }
            j++;
        }
    }
    public static void printBoard(char[][] board, int row, int col, String boardName){
        System.out.printf("\nThis is the %s board: \n", boardName);
        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                System.out.print(board[i][k]+" ");
            }
            System.out.println();
        }
    }
}
