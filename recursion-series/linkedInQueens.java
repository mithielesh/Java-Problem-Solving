import java.util.*;
public class linkedInQueens {
    // Initially creating this with an assumptiom that there are no preplaced queens need to add that later
    public static void nQueens(List<List<Character>> board, int n){
        boolean[][] queenPlaced = new boolean[n][n];
        HashSet<Character> usedState = new HashSet<>();
        if(!queenSetter(board,queenPlaced,usedState,n,0)){
            System.out.println("No solution found.");
        }
    }
    public static boolean queenSetter(List<List<Character>> board, boolean[][] queenPlaced, HashSet<Character> usedState, int n, int col){
        if(col == n){
            System.out.println("A valid board configuration is:");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(queenPlaced[i][j]){
                        System.out.print("Q ");
                    }else{
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            return true;
        }
        // We are setting up the movement for the placement of the queemns
        for(int row=0;row<n;row++){
            char color = board.get(row).get(col);
            if(isValid(board,queenPlaced,usedState,n,row,col,color)){
                queenPlaced[row][col] = true;
                usedState.add(color);
                if(queenSetter(board,queenPlaced,usedState,n,col+1)){
                    return true;
                }
                // Backtracking is also done back to the color if it cannot be placed 
                queenPlaced[row][col] = false;
                usedState.remove(color);
            }
        }
        return false;
    }
    public static boolean isValid(List<List<Character>> board, boolean[][] queenPlaced,  HashSet<Character> usedState, int n, int row, int col, char color){
        if(usedState.contains(color)){
            return false;
        }
        for(int i=0;i<n;i++){
            // Check if the queen is along the same row
            if(queenPlaced[row][i]){
                return false;
            }
            // Check if the queen is present along the same column
            if(queenPlaced[i][col]){
                return false;
            }
        }
        // Check along the queen in the 4 diagonal cells
        if((row > 0 && col > 0) && queenPlaced[row-1][col-1]){
            return false;
        }
        if((row < n-1 && col > 0) && queenPlaced[row+1][col-1]){
                return false;
        }
        // Doing the check across the board for the colors. But one thing that is known in the board the colors are together
        // I can use a recursive function to do DFS traversing to check if the Q exists in the color or not but for now I am going to 
        // traverse the entire board every time it is called
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(board.get(i).get(j) == color){
        //             if(queenPlaced[i][j]){
        //                 return false;
        //             }
        //         }
        //     }
        // }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board: ");
        int n = sc.nextInt();
        sc.nextLine();
        List<List<Character>> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Character> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(sc.next().charAt(0));
            }
            board.add(row);
        }
        nQueens(board,n);
        sc.close();
    }
}
