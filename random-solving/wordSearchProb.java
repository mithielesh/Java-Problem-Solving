import java.util.*;
public class wordSearchProb {
    public static boolean wordSearch(char[][] grid, int r, int c, String word){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == word.charAt(0)){
                    if(explore(grid,r,c,i,j,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean explore(char[][] grid, int r, int c, int i, int j, String word, int index){
        if(index == word.length()) return true;

        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] != word.charAt(index)) return false;

        char originalLetter = grid[i][j];
        grid[i][j] = '#';

        boolean found = explore(grid,r,c,i-1,j,word,index+1) ||
                        explore(grid,r,c,i+1,j,word,index+1) ||
                        explore(grid,r,c,i,j-1,word,index+1) ||
                        explore(grid,r,c,i,j+1,word,index+1);

        grid[i][j] = originalLetter;
        return found;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the word to search: ");
        String word = sc.nextLine();
        char[][] grid = new char[r][c];
        System.out.println("Enter the elements in the grid: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        boolean ans = wordSearch(grid,r,c,word);
        if(ans) System.out.println("The word exists");
        else System.out.println("The word does not exist");
        sc.close();
    }
}
