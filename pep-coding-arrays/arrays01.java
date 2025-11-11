import java.util.*;

public class arrays01 {
    public static int span(int[] arr, int n) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Setting up empty array check
        if (arr.length == 0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int span = max - min;
        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int span = span(arr, n);
        System.out.println("Span of the array is: " + span);
        sc.close();
    }
}
