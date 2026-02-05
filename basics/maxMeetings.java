import java.util.*;
public class maxMeetings {
    public static int nMeetings(int[] start, int[] end){
        int n = start.length;
        int[][] meetings = new int[n][2];
        for(int i = 0; i < n; i++){
            meetings[i][0] = end[i];
            meetings[i][1] = start[i];
        }
        Arrays.sort(meetings, (a1,a2) -> {
            return a1[0] - a2[0];
        });
        // First meeting always takes place so keep the count as 1 and start from the second meeting 
        // And the lastEndTime is initialized to the end time of the first meeting end time
        int count = 1;
        int lastEndTime = meetings[0][0];
        for(int i = 1; i < n; i++){
            if(lastEndTime < meetings[i][1]){
                lastEndTime = meetings[i][0];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            end[i] = sc.nextInt();
        }
        int count = nMeetings(start, end);
        System.out.println(count);
        sc.close();
    }
}
