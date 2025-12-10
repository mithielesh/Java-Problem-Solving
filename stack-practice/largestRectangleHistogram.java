import java.util.*;

public class largestRectangleHistogram {
    public static int greatestAreaRectangle(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] smallLeft = new int[n];
        int[] smallRight = new int[n];
        // First trying to find the smaller ones on the left
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= num) {
                stack.pop();
            }
            // We need to subtract one as the element that broke the loop is not counted
            if (!stack.isEmpty())
                smallLeft[i] = stack.peek();
            else
                smallLeft[i] = -1;

            stack.push(i);
        }
        // printArr(smallLeft);
        emptyStack(stack);
        // Then find the smaller ones on the right
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= num) {
                stack.pop();
            }
            // We need to add one as the element that broke the loop is not counted
            if (!stack.isEmpty())
                smallRight[i] = stack.peek();
            else
                smallRight[i] = n;

            stack.push(i);
        }
        // printArr(smallRight);
        emptyStack(stack);

        // Then we find the area and the largest one at that
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (smallRight[i] - smallLeft[i] - 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void emptyStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxArea = greatestAreaRectangle(arr);
        System.out.println(maxArea);
        sc.close();
    }
}
