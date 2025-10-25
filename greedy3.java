// Shortest job first algorithm
import java.util.*;
public class greedy3 {
    public static double calcAvgWaitTime(List<Integer> arr, int n){
        Collections.sort(arr);
        int waitTime = 0;
        int totalWaitTime = 0;
        for(int i=1;i<n;i++){
            waitTime += arr.get(i-1);
            totalWaitTime += waitTime;
        }
        System.out.println(totalWaitTime);
        double avgWaitTime = (double)totalWaitTime / (double)n;
        return avgWaitTime;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Integer> process = new ArrayList<>();
        for(int i=0;i<n;i++){
            process.add(sc.nextInt());
        }
        double avgWaitTime = calcAvgWaitTime(process, n);
        System.out.printf("The average wait time is: %.2f",avgWaitTime);
        sc.close();
    }
}
