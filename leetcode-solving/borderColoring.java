public class borderColoring {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        // The squares that are connected a different component or to the edge of the grid count as border
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int element = grid[row][col];
        helper(grid,visited,row,col,n,m,color,element);
        return grid;
    }
    private void helper(int[][] grid, boolean[][] visited, int r, int c, int n, int m, int color, int element) {
        if(r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || grid[r][c] != element) {
            return;
        }
        if(isValidBorder(grid,r,c,n,m,visited)) {
            grid[r][c] = color;
        }
        visited[r][c] = true;
        helper(grid,visited,r+1,c,n,m,color,element);
        helper(grid,visited,r-1,c,n,m,color,element);
        helper(grid,visited,r,c+1,n,m,color,element);
        helper(grid,visited,r,c-1,n,m,color,element);
    }
    private boolean isValidBorder(int[][] grid, int r, int c, int n, int m, boolean[][] visited) {
        /*
            If the element is visited then it is the same component element even if it has been modified 
            If it has not been visited it can be either the same component element or an actual different element
        */
        int element = grid[r][c];
        if((r+1) == n || (r-1) == -1 || (c-1) == -1 || (c+1) == m) {
            return true;
        }
        if((r+1) < n && !visited[r+1][c] && grid[r+1][c] != element) {
            return true;
        } 
        if((r-1) >= 0 && !visited[r-1][c] && grid[r-1][c] != element) {
            return true;
        }
        if((c+1) < m && !visited[r][c+1] && grid[r][c+1] != element) {
            return true;
        }
        if((c-1) >= 0 && !visited[r][c-1] && grid[r][c-1] != element) {
            return true;
        }
        return false;
    }
}