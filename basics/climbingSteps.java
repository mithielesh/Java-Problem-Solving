import java.util.*;
public class climbingSteps {
    // need to make sure he climbs in exponents of 2 and gets down by 1
    private static long climbing(int m){
        HashMap<String, Long> memo = new HashMap<>();
        long steps = helper(1,m,0,'u',memo);
        return steps;
    }
    private static long helper(long steps, int m, long exp, char move, HashMap<String,Long> memo){
        if(steps >= m+2){
            return 0;
        }
        String key = steps + "," + exp + "," + move;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        long count = 0;
        if(steps == m){
            count++;
        }
        long climb = (long)Math.pow(2,exp);
        long up = 0, down = 0;
        up = helper(steps+climb,m,exp+1,'u',memo);
        if(steps > 0 && move != 'd'){
            down = helper(steps-1,m,exp,'d',memo);
        }
        long totalWays = count + up + down;
        memo.put(key,totalWays);
        return totalWays;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int i = 0; i <= m; i++){
            long steps = climbing(i);
            System.out.print(steps+" ");
        }
        sc.close();
    }
}
