import java.util.*;
public class mostFrequentCharacter {
    public static List<Character> mFC(String s){
        Pair[] freq = new Pair[26];
        for(int i = 0; i < 26; i++){
            freq[i] = new Pair(0, (char)(i + 'a'));
        }
        for(char ch : s.toCharArray()){
            freq[ch - 'a'].freq++;
        }
        Arrays.sort(freq, (p1,p2) ->{
            if(p1.freq != p2.freq) return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });
        List<Character> list = new ArrayList<>();
        for(Pair p : freq){
            if(p.freq == 0) break;
            list.add(p.ch);
        }
        return list;
    }
    // Creating the helper class
    static class Pair{
        int freq;
        char ch;
        Pair(int f, char c){
            this.freq = f;
            this.ch = c;
        }
    }

    public static List<Character> mFC2(String s){
        // This is a way of doing it using 2 TreeMaps
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                int count = map.get(ch) + 1;
                map.put(ch,count);
            }
            else{
                map.put(ch,1);
            }
        }
        TreeMap<Integer, List<Character>> mapChecker = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            if(mapChecker.containsKey(val)){
                mapChecker.get(val).add(key);
            }
            else{
                List<Character> list = new ArrayList<>();
                list.add(key);
                mapChecker.put(val,list);
            }
        }
        List<Character> list = new ArrayList<>();
        for(List<Character> lists : mapChecker.values()){
            for(char ch : lists){
                list.add(ch);
            }
        }
        return list;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<Character> ans = mFC2(s);
        System.out.println(ans);
        sc.close();
    }
}
