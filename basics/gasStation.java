import java.util.*;
public class gasStation {
    public static int path(int[] gas, int[] cost){
        int n = gas.length;
        for(int i = 0; i < n; i++){
            int spend = gas[i] - cost[i];
            if(spend >= 0){
                int index = i+1;
                int balanceFuel = spend;
                while(balanceFuel >= 0){
                    int ind = index % n;
                    if(ind == i){
                        return i;
                    }
                    balanceFuel += gas[ind] - cost[ind];
                    index++;
                }
                if(index > n) return -1;
                i = index-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] gas = new int[n];
        for(int i = 0; i < n; i++){
            gas[i] = sc.nextInt();
        }
        int[] cost = new int[n];
        for(int i = 0; i < n; i++){
            cost[i] = sc.nextInt();
        }
        int index = path(gas,cost);
        System.out.println(index);
        sc.close();
    }
}
