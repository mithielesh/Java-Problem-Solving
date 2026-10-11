public class 2DQuery {
    int[][] mat;
    int n, m;
    public NumMatrix(int[][] matrix) {
        n = matrix.length; m = matrix[0].length;
        mat = matrix;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < m; j++) {
                sum += mat[i][j];
                mat[i][j] = sum;
                if(i != 0) {
                    mat[i][j] += mat[i-1][j]; 
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = mat[row2][col2];
        if(row1 > 0) {
            sum -= mat[row1-1][col2];
            if(col1 > 0) {
                sum += mat[row1-1][col1-1];
            }
        }
        if(col1 > 0) {
            sum -= mat[row2][col1-1];
        }
        return sum;
    }
}
