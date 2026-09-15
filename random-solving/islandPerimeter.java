import java.util.*;
public class islandPerimeter {
    public static int findPerimeter(int[][] grid, int r, int c){
        // This entire solving is with the assumption that there is only one island
        int perimeter = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    perimeter += isSurrounded(grid,i,j,r,c);
                }
            }
        }
        return perimeter;
    }
    public static int isSurrounded(int[][] grid, int i, int j, int r, int c){
        int peri = 0;

        // Check Up
        if (i == 0 || grid[i-1][j] == 0) peri++;
        // Check Down
        if (i == r-1 || grid[i+1][j] == 0) peri++;
        // Check Left
        if (j == 0 || grid[i][j-1] == 0) peri++;
        // Check Right
        if (j == c-1 || grid[i][j+1] == 0) peri++;
        
        return peri;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt();
        System.out.println("Enter the elements in the grid:");
        int[][] grid = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int perimeter = findPerimeter(grid,r,c);
        System.out.println("The perimeter of the islands is: "+perimeter);
        sc.close();
    }
}
