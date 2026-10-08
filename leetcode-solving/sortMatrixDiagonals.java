public class sortMatrixDiagonals {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int ind = m-1; 
        while(ind >= 0) {
            List<Integer> temp = new ArrayList<>();
            int r = 0, c = ind, ptr = 0;
            while(r < n && c < m) {
                temp.add(mat[r][c]);
                r++; c++;
            }
            Collections.sort(temp);
            r = 0; c = ind;
            while(r < n && c < m) {
                mat[r][c] = temp.get(ptr);
                r++; c++; ptr++;
            }
            ind--;
        }
        ind = 1;
        while(ind < n) {
            List<Integer> temp = new ArrayList<>();
            int r = ind, c = 0, ptr = 0;
            while(r < n && c < m) {
                temp.add(mat[r][c]);
                r++; c++;
            }
            Collections.sort(temp);
            r = ind; c = 0;
            while(r < n && c < m) {
                mat[r][c] = temp.get(ptr);
                r++; c++; ptr++;
            }
            ind++;
        }
        return mat;
    }
}