public class maxFishInGrid {
    public int findMaxFish(int[][] grid) {
        // Brute force
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0 && !visited[i][j]) {
                    max = Math.max(max, fisher(grid,visited,i,j,n,m));
                }
            }
        }
        return max;
    }
    private int fisher(int[][] grid, boolean[][] visited, int r, int c, int n, int m) {
        if(r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        int down = fisher(grid,visited,r+1,c,n,m);
        int up = fisher(grid,visited,r-1,c,n,m);
        int right = fisher(grid,visited,r,c+1,n,m);
        int left = fisher(grid,visited,r,c-1,n,m);
        return down + up + right + left + grid[r][c];
    }
}