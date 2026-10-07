class Pair {
    int time;
    String val;

    public Pair(int timestamp, String value) {
        this.time = timestamp;
        this.val = value;
    }
}
public class timeMap {
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        map.computeIfAbsent(key, list -> new ArrayList<>()).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Pair> list = map.get(key);
        int l = 0, r = list.size()-1;
        Pair bestCandidate = new Pair(-1,"");
        while(l <= r) {
            int mid = l + (r-l)/2;
            int time = list.get(mid).time;
            if(time == timestamp) {
                return list.get(mid).val;
            }
            else if(time < timestamp) {
                bestCandidate = list.get(mid);
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        if(bestCandidate.time == -1) {
            return "";
        }
        return bestCandidate.val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */