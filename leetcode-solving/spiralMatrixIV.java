import java.util.Arrays;

public class spiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for(int[] row : matrix) {
            Arrays.fill(row, -1);
        }
        int top = 0, bottom = m-1, left = 0, right = n-1, index = 0;
        ListNode cur = head;
        while(cur != null) {
            index = left;
            while(cur != null && index <= right) {
                matrix[top][index] = cur.val;
                cur = cur.next;
                index++;
            }
            top++;
            index = top;
            while(cur != null && index < bottom) {
                matrix[index][right] = cur.val;
                cur = cur.next;
                index++;
            }
            right--;
            if(bottom >= top) {
                index = right+1;
                while(cur != null && index >= left) {
                    matrix[bottom][index] = cur.val;
                    cur = cur.next;
                    index--;
                }
                bottom--;
            }
            if(left <= right) {
                index = bottom;
                while(cur != null && index >= top) {
                    matrix[index][left] = cur.val;
                    cur = cur.next;
                    index--;
                }
                left++;
            }
        }
        return matrix;
    }
}
