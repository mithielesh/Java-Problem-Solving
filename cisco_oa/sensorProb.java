import java.util.*;

public class sensorProb {
    private static int noOfSensors(int[] arr, int range) {
        int sensors = 0, n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            int totRange = arr[i] + (range * 2);
            while(i < n && arr[i] <= totRange) {
                i++;
            }
            i--;
            sensors++;
        }
        return sensors;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int range = sc.nextInt();
        System.out.println(noOfSensors(arr,range));
        sc.close();
    }
}
