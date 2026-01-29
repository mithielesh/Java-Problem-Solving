import java.util.*;
public class mergeIntervals {
    public static int[][] merger(int[][] intervals){
        int n = intervals.length;
        Arrays.sort(intervals, (i1,i2) -> {
            return i1[0] - i2[0];
        });
        List<int[]> list = new ArrayList<>();
        int end = intervals[0][1], start = intervals[0][0];
        for(int i = 1; i < n; i++){
            if(intervals[i][0] <= end){
                if(intervals[i][1] > end){
                    end = intervals[i][1];
                }
            }
            else{
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        
        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int[][] ans = merger(intervals);
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i][0] + " " + ans[i][1] + "\t");
        }
        sc.close();
    }
}
