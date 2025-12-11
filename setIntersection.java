import java.util.*;
public class setIntersection {
    public static int intersectionSizeTwo(int[][] intervals){
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) ->{
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            else{
                return a[1] - b[1];
            }
        });
        int count = 0;
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                intervals[i][j] = sc.nextInt();
            }
        }
        int count = intersectionSizeTwo(intervals);
        System.out.print(count);
        sc.close();
    }
}
