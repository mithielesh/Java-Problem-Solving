import java.util.*;

public class networkLatency {
    private static int[] latencyCalculator(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] latencies = new int[n];
        for(int i = n-1; i >= 0; i--) {
            int time = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] <= time) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                latencies[i] = 0;
            }
            else {
                latencies[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return latencies;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] latencies = latencyCalculator(arr);
        for(int i = 0; i < latencies.length; i++) {
            System.out.print(latencies[i] + " ");
        }
        sc.close();
    }
}
