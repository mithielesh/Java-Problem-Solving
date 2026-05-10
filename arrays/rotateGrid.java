import java.utils.*;

public rotateGrid {
    private static int[][] gridRotater(int[][] grid, int k) {
        /*
        Using extreme brute force
        [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]] 
        The layers are:
        [1,5,9,13,14,15,16,12,8,4,3,2] [6,10,11,7]
        */

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Both should be multiples of 2
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int[][] ans = gridRotater(grid,k);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(ans[i][j] +" ");
            }
            System.out.println();
        }
    }
}