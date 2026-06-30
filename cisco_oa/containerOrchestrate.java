import java.util.*;

public class containerOrchestrate {
    private static int smartMemAllocate(int[] arr) {
        int totSum = Arrays.stream(arr).sum();
        Integer[][] memo = new Integer[arr.length][totSum+1];
        return allocator(arr, totSum, 0, 0, memo);
    }
    private static int allocator(int[] arr, int totSum, int sum, int index, Integer[][] memo) {
        if(index == arr.length) {
            return Math.abs(sum - totSum);
        }
        if(memo[index][sum] != null) {
            return memo[index][sum];
        }
        int pick = allocator(arr, totSum - arr[index], sum + arr[index], index + 1, memo);
        int notPick = allocator(arr, totSum, sum, index + 1, memo);
        return memo[index][sum] = Math.min(pick,notPick);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memoryAllocated = new int[n];
        for(int i = 0; i < n; i++) {
            memoryAllocated[i] = sc.nextInt();
        }
        System.out.println(smartMemAllocate(memoryAllocated));
        sc.close();
    }
}
