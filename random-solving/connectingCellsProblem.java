import java.util.*;
public class connectingCellsProblem {
    public static void connectingCells(int[][] grid, int n, int m){
        int maxCount = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int count = explore(grid,i,j,n,m);
                    if(count > maxCount) maxCount = count;
                }
            }
        }
        System.out.println(maxCount);
    }
    public static int explore(int [][] grid,int i,int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0){
            return 0;
        }
        int count = 0;
        grid[i][j] = 0;
        count++;
        count += explore(grid, i-1,j,n,m);
        count += explore(grid, i+1,j,n,m);
        count += explore(grid, i,j-1,n,m);
        count += explore(grid, i,j+1,n,m);
        count += explore(grid, i-1,j-1,n,m);
        count += explore(grid, i-1,j+1,n,m);
        count += explore(grid, i+1,j-1,n,m);
        count += explore(grid, i+1,j+1,n,m);
         return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        connectingCells(grid,n,m);
        sc.close();
    }
}