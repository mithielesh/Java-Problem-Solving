import java.util.*;

public class leakyBucketVar {
    private static int leak(int[][] requests, int rate, int maxPackets) {

        Arrays.sort(requests, (a,b) -> {
            return Integer.compare(a[0],b[0]);
        });

        int bucket = requests[0][1];
        int leaks = 0;

        if(bucket > maxPackets) {
            leaks += bucket - maxPackets;
            bucket = maxPackets;
        }

        for(int i = 1; i < requests.length; i++) {

            int time = requests[i][0];

            int timeElapsed = time - requests[i-1][0];

            int packetsTransferred = timeElapsed * rate;

            bucket = Math.max(0,bucket - packetsTransferred);
            bucket += requests[i][1];

            if(bucket > maxPackets) {
                leaks += bucket - maxPackets;
                bucket = maxPackets;
            }
        }
        
        return leaks;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] requests = new int[n][2];
        for(int i = 0; i < n; i++) {
            requests[i][0] = sc.nextInt();
            requests[i][1] = sc.nextInt();
        }
        int rate = sc.nextInt();
        int maxPackets = sc.nextInt();
        System.out.print(leak(requests,rate,maxPackets));
    }
} 