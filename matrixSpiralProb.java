import java.util.*;
public class matrixSpiralProb {
    public static List<Integer> spiralMatrix(int[][] matrix, int r, int c){
        List<Integer> ans = new ArrayList<>();
        int layers = Math.min(r,c) / 2;
        // follow the same logic as the matrix layer rotation problem
        int top = 0, right = c-1, bottom = r-1, left = 0;

        for(int i = 0; i < layers; i++){
            for(int j=left;j<=right;j++){
                ans.add(matrix[top][j]);
            }
            for(int j=top+1;j<=bottom;j++){
                ans.add(matrix[j][right]);
            }
            for(int j=right-1;j>=left;j--){
                ans.add(matrix[bottom][j]);
            }
            for(int j=bottom-1;j>=top+1;j--){
                ans.add(matrix[j][left]);
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        if (top <= bottom) { // Check if at least one row is left
            
            // Case 1: A single horizontal row is left (e.g., 3x5 matrix)
            // This also handles the single center element (e.g., 3x3 matrix)
            if (top == bottom) { 
                for (int j = left; j <= right; j++) {
                    ans.add(matrix[top][j]);
                }
            } 
            // Case 2: A single vertical column is left (e.g., 5x3 matrix)
            else if (left == right) {
                for (int j = top; j <= bottom; j++) {
                    ans.add(matrix[j][left]);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        List<Integer> ans = spiralMatrix(matrix,r,c);
        System.out.println("The elements in the spiral order are: ");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
