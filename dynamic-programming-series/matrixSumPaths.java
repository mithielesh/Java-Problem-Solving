import java.util.*;
public class matrixSumPaths {
    public static int numberOfPaths(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][k];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int count = recur(grid,0,0,r,c,k,0,dp);
        return count;
    }
    public static int recur(int[][] grid, int i, int j, int r, int c, int k, int rem, int[][][] dp) {
        if(i < 0 || i >= r || j < 0 || j >= c || k < 0) {
            return 0;
        }
        rem = (rem + grid[i][j]) % k;
        if(i == r-1 && j == c-1){
            if(rem == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][j][rem] != -1){
            return dp[i][j][rem];
        }
        int down = 0, right = 0;
        if(i < r-1){
            down = recur(grid,i+1,j,r,c,k,rem,dp);
        }
        if(j < c-1){
            right = recur(grid,i,j+1,r,c,k,rem,dp);
        }
        return dp[i][j][rem] = (down+right) % 1000000007;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int paths = numberOfPaths(grid,k);
        System.out.println(paths);
        sc.close();
    }
}
