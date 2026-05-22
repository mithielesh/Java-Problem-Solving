import java.util.*;

public class summaryRange {
    private static List<String> rangeSummary(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            

            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<String> ans = rangeSummary(arr);
        for(String range : ans) {
            System.out.println(range+" ");
        }
        sc.close();
    }
}