public class mapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < isWater.length; i++) {
            for(int j = 0; j < isWater[0].length; j++) {
                if(isWater[i][j] == 1) {
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int peakHeight = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] coord = q.poll();
                int r = coord[0], c = coord[1];
                isWater[r][c] = peakHeight;
                if(r > 0 && !visited[r-1][c]) {
                    q.offer(new int[]{r-1,c});
                    visited[r-1][c] = true;
                }
                if(r < n-1 && !visited[r+1][c]) {
                    q.offer(new int[]{r+1,c});
                    visited[r+1][c] = true;
                }
                if(c > 0 && !visited[r][c-1]) {
                    q.offer(new int[]{r,c-1});
                    visited[r][c-1] = true;
                }
                if(c < m-1 && !visited[r][c+1]) {
                    q.offer(new int[]{r,c+1});
                    visited[r][c+1] = true;
                }
            }
            peakHeight++;
        }
        return isWater;
    }
}