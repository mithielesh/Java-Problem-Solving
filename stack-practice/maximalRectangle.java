import java.util.*;

public class maximalRectangle {
    public static int findMaxArea(int[][] matrix){

        int r = matrix.length;
        int c = matrix[0].length;
        int[] heights = new int[c];
        int maxArea = 0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 1){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }
            int area = helperMaxAreaRect(heights);
            if(area > maxArea) maxArea = area;
        }

        return maxArea;
    }
    public static int helperMaxAreaRect(int[] heights){

        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] rightMin = new int[n];
        int[] leftMin = new int[n];

        // This is for the leftMin
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) leftMin[i] = stack.peek();
            else leftMin[i] = -1;
            stack.push(i);
        }
        while(!stack.isEmpty()) stack.pop();

        // This is for the rightMin
        for(int i=heights.length - 1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) rightMin[i] = stack.peek();
            else rightMin[i] = n;
            stack.push(i);
        }
        while(!stack.isEmpty()) stack.pop();

        int max = 0;
        for(int i=0;i<n;i++){
            int area = heights[i] * (rightMin[i] - leftMin[i] - 1);
            if(area > max){
                max = area;
            }
        }

        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int area = findMaxArea(matrix);
        System.out.println(area);
        sc.close();
    }    
}
