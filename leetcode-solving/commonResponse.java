
public class commonResponse {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0;
        for(List<String> list : responses) {
            HashSet<String> set = new HashSet<>();
            for(String response : list) {
                set.add(response);
            }
            for(String response : set) {
                if(!map.containsKey(response)) {
                    max = Math.max(max,1);
                    map.put(response,1);
                }
                else {
                    int freq = map.get(response) + 1;
                    max = Math.max(max,freq);
                    map.put(response,freq);
                }
            }
        }
        String[] ans = new String[1];
        ans[0] = "";
        for(HashMap.Entry<String,Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if(val == max) {
                if(ans[0] == "") {
                    ans[0] = key;
                }
                else {
                    if(ans[0].compareTo(key) > 0) {
                        ans[0] = key;
                    }
                }
            }
        }
        return ans[0];
    }
}