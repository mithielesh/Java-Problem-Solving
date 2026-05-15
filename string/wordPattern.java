import java.util.*;
public class wordPattern {
    private static boolean patternMatcher(String pattern, String s) {

        String[] words = s.trim().split(" ");
        if(words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> mapBack = new HashMap<>();
        
        int n = pattern.length();
        for(int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if(map.containsKey(c)) {
                if(!map.get(c).equals(word)) {
                    return false;
                }
            } else {
                map.put(c,word);
            }
        }

        for(int i = 0; i < n; i++) {
            String word = words[i];
            char c = pattern.charAt(i);
            if(mapBack.containsKey(word)) {
                if(mapBack.get(word) != c) {
                    return false;
                }
            } else {
                mapBack.put(word,c);
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.next();
        String s = sc.nextLine();
        if(patternMatcher(pattern,s)) {
            System.out.print("True");
        }
        else {
            System.out.print("False");
        }
        sc.close();
    }
}