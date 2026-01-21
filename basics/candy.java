import java.util.*;
public class candy {
    public static int findCandies(int[] arr){
        int n = arr.length;
        int[] leftLimit = new int[n];
        int[] rightLimit = new int[n];
        Arrays.fill(leftLimit,1);
        Arrays.fill(rightLimit,1);
        // Doing the left pass
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[i-1]){
                leftLimit[i] = leftLimit[i-1] + 1;
            }
        }
        // Doing the right pass
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] > arr[i+1]){
                rightLimit[i] = rightLimit[i+1] + 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Math.max(leftLimit[i], rightLimit[i]);
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int candy = findCandies(arr);
        System.out.println(candy);
        sc.close();
    }
}
