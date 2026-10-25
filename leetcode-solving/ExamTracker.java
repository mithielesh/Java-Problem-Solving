class ExamTracker {
    List<Integer> times;
    List<Long> prefix;
    public ExamTracker() {
        times = new ArrayList<>();
        prefix = new ArrayList<>();
        prefix.add((long)0);
    }
    
    public void record(int time, int score) {
        times.add(time);
        prefix.add(score + prefix.get(prefix.size()-1));
    }
    
    public long totalScore(int startTime, int endTime) {
        int sInd = binSearchHigher(0,times.size()-1,startTime);
        if(sInd == -1 || times.get(sInd) > endTime) {
            return 0;
        }
        int eInd = binSearchLower(sInd,times.size()-1,endTime);
        if(eInd == -1) {
            return 0;
        }
        if(sInd == eInd) {
            return prefix.get(sInd+1) - prefix.get(sInd);
        }
        return prefix.get(eInd+1) - prefix.get(sInd);
    }

    public int binSearchHigher(int l, int r, int time) {
        int ans = -1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(times.get(mid) == time) {
                return mid;
            }
            else if(times.get(mid) < time) {
                l = mid + 1;
            }
            else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }
    public int binSearchLower(int l, int r, int time) {
        int ans = -1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(times.get(mid) == time) {
                return mid;
            }
            else if(times.get(mid) < time) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */