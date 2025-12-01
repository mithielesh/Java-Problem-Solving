import java.util.*;
public class ninjaRoutine {
    public static int prepareRoutine(int[][] schedule){
        int n = schedule.length;
        int m = schedule[0].length;
        int[][] dp = new int[n][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int max = getMaxMemoized(schedule,-1,n,m,0,dp);
        return max;
    }
    public static int getMax(int[][] schedule, int performedTask, int n, int m, int sum, int ind){
        if(ind == n){
            return sum;
        }
        // Now do the actual calculating part
        int max = 0;
        for(int i=0;i<m;i++){
            if(i != performedTask){
                int val = getMax(schedule,i,n,m,sum+schedule[ind][i],ind+1);
                if(val > max){
                    max = val;
                }
            }
        }
        return max;
    }
    // Dont add the sum as a parameter cause we need to memoize
    public static int getMaxMemoized(int[][] schedule, int performedTask, int n, int m, int ind, int[][] dp){
        // Base case remains the same
        if(ind == n){
            return 0;
        }
        // If the value is already memoized I can return it
        if(dp[ind][performedTask+1] != -1){
            return dp[ind][performedTask+1];
        }
        int max = 0;
        for(int i=0;i<m;i++){
            if(i != performedTask){
                int val = schedule[ind][i] + getMaxMemoized(schedule,i,n,m,ind+1,dp);
                if(val > max){
                    max = val;
                }
            }
        }
        return dp[ind][performedTask+1] = max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int activities = sc.nextInt();
        int days = sc.nextInt();
        int[][] schedule = new int[days][activities];
        for(int i=0;i<days;i++){
            for(int j=0;j<activities;j++){
                schedule[i][j] = sc.nextInt();
            }
        }
        int max = prepareRoutine(schedule);
        System.out.println(max);
        sc.close();
    }
}
