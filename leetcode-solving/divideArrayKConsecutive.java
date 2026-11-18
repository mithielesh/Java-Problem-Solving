public class divideArrayKConsecutive {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) {
            return false;
        } 
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max = map.lastKey()+1;
        while(map.size() != 0) {
            int start = map.firstKey(), end = start + k;
            if(end > max) {
                return false;
            }
            while(start < end) {
                if(map.containsKey(start)) {
                    int freq = map.get(start);
                    if(freq == 1) {
                        map.remove(start);
                    }
                    else {
                        map.replace(start,freq-1);
                    }
                }
                else {
                    return false;
                }
                start++;
            }
        }
        return true;
    }
}