import java.util.*;
public class shiftingZeros {
    public static void shiftZero(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] shifted = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    shifter(shifted,i,j,n,m);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(shifted[i][j]){
                    mat[i][j] = 0;
                }
            }
        }
    }
    public static void shifter(boolean[][] visited, int oi, int oj, int n, int m){
        // top
        if(oi > 0){
            for(int i=oi-1;i>=0;i--){
                visited[i][oj] = true;
            }
        }
        // bottom
        if(oi < n-1){
            for(int i=oi+1;i<n;i++){
                visited[i][oj] = true;
            }
        }
        // left
        if(oj > 0){
            for(int j=oj-1;j>=0;j--){
                visited[oi][j] = true;
            }
        }
        // right
        if(oj < m-1){
            for(int j=oj+1;j<m;j++){
                visited[oi][j] = true;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] mat = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        shiftZero(mat);
        System.out.println();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
