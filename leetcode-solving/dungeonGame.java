public class dungeonGame {
    public int calculateMaxPath(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return helper(dungeon,dp,0,0,n,m);
    }
    private int helper(int[][] dungeon, int[][] dp, int i, int j, int n, int m) {
        if(i < 0 || i >= n || j < 0 || j >= m) {
            return -10000;
        }
        if(i == n-1 || j == m-1) {
            return dungeon[n-1][m-1];
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = dungeon[i][j] + helper(dungeon,dp,i+1,j,n,m);
        int right = dungeon[i][j] + helper(dungeon,dp,i,j+1,n,m);
        return dp[i][j] = Math.max(right,down);
    }
}