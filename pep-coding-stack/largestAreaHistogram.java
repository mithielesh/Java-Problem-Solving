import java.util.*;

public class largestAreaHistogram {
    public static int findLargestArea(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        // First find the next smaller element on the left
        int[] lIndex = new int[n];
        for(int i=0;i<n;i++){
            int num = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >= num){
                stack.pop();
            }
            if(!stack.isEmpty()) lIndex[i] = stack.peek();
            else lIndex[i] = -1;

            stack.push(i);
        }
        while(!stack.isEmpty()) stack.pop();

        // First find the next smaller element on the right
        int[] rIndex = new int[n];
        for(int i=n-1;i>=0;i--){
            int num = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >= num){
                stack.pop();
            }
            if(!stack.isEmpty()) rIndex[i] = stack.peek();
            else rIndex[i] = n;

            stack.push(i);
        }
        while(!stack.isEmpty()) stack.pop();

        int max = 0;
        for(int i=0;i<n;i++){
            int area = heights[i] * (rIndex[i] - lIndex[i] - 1);
            if(area > max){
                max = area;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        int area = findLargestArea(heights);
        System.out.println(area);
        sc.close();
    }    
}
