public class minTimeDiff {
    public int findMinDifference(List<String> times) {
        // Only reason I am using a treeset is because it helps with shortcircuting and keeps elements sorted
        int n = times.size();
        if(n > 1440) {
            return 0;
        }
        boolean[] seen = new boolean[1440];
        int[] arr = new int[n];
        int ind = 0;
        for(String time : times) {
            int hours = Integer.parseInt(time.substring(0,2));
            int mins = Integer.parseInt(time.substring(3,5));
            mins += (hours * 60);
            if(seen[mins]) {
                return 0;
            }
            seen[mins] = true;
            arr[ind] = mins;
            ind++;
        }
        Arrays.sort(arr);
        int min = (1440 - arr[n-1]) + arr[0];
        for(int i = 1; i < n; i++) {
            min = Math.min(min, arr[i] - arr[i-1]);
        }
        return min;
    }
}