import java.util.*;
public class linkedInQueensFinal {
    public static void nQueens(List<List<Character>> board, boolean[][] visited, HashSet<Character> usedColor, int n){
        
        if(!queenPlacer(board,visited,usedColor,0,n)){
            System.out.println("No solution found for this board.");
        }
    }
    public static boolean queenPlacer(List<List<Character>> board, boolean[][] visited, HashSet<Character> usedColor, int col, int n){
        if(col == n){
            System.out.println("A valid configuration for this board is:");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(visited[i][j]){
                        // Print a Q colored by its region
                        System.out.print(colorize(board.get(i).get(j), "Q") + " ");
                    } else {
                        // Print the region letter (colored)
                        System.out.print(colorize(board.get(i).get(j), ".") + " ");
                    }
                }
                System.out.println();
            }
            return true;
        }
        int r = alreadyPlaced(visited,n,col);
        if(r == -1){
            for(int row=0;row<n;row++){
                char color = board.get(row).get(col);
                if(isValid(visited,usedColor,row,col,n,color)){
                    visited[row][col] = true;
                    usedColor.add(color);
                    if(queenPlacer(board,visited,usedColor,col+1,n)){
                        return true;
                    }else{
                        visited[row][col] = false;
                        usedColor.remove(color);
                    }
                }
            }
            return false;
        }
        // No need to check for the validity of the queen as it is believed to be placed correctly already
        if(queenPlacer(board,visited,usedColor,col+1,n)){
            return true;
        }
        return false;
    }
    public static boolean isValid(boolean[][] visited, HashSet<Character> usedColor, int row, int col, int n, char color){

        if(usedColor.contains(color)) return false;

        for(int i = 0; i < n; i++){

            if(visited[row][i]) return false;

            if(visited[i][col]) return false;
        }


        if((row > 0 && col > 0) && (visited[row-1][col-1])) return false;

        if((row > 0 && col < n-1) && (visited[row-1][col+1])) return false;

        if((row < n-1 && col > 0) && (visited[row+1][col-1])) return false;

        if((row < n-1 && col < n-1) && (visited[row+1][col+1])) return false;


        return true;
    }
    public static int alreadyPlaced(boolean[][] visited, int n, int col){
        int r = 0;
        while(r < n){
            if(visited[r][col]) return r;
            r++;
        }
        return -1;
    }
    public static String colorize(char region, String text) {
        // Maps 'A'->Red, 'B'->Green... repeating every 6 colors
        int colorCode = 31 + (region - 'A') % 6; 
        return "\u001B[" + colorCode + "m" + text + "\u001B[0m";
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the elements of the board:");
        List<List<Character>> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Character> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(sc.next().charAt(0));
            }
            board.add(row);
        }
        System.out.print("Enter the number of queens: ");
        int q = sc.nextInt();
        List<List<Integer>> coordinates = new ArrayList<>();
        System.out.println("Enter the coordinates of the queens: ");
        for(int i=0;i<q;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<2;j++){
                list.add(sc.nextInt());
            }
            coordinates.add(list);
        }
        boolean[][] visited = new boolean[n][n];
        HashSet<Character> usedColor = new HashSet<>();
        for(List<Integer> list : coordinates){
            visited[list.get(0)][list.get(1)] = true;
            usedColor.add(board.get(list.get(0)).get(list.get(1)));
        }
        nQueens(board,visited,usedColor,n);
        sc.close();
    }
}
