import java.util.*;
public class commonCharacters {
    public static List<String> getCommon(String[] words){
        int[] alpha = new int[26];
        for(int j = 0; j < words[0].length(); j++){
                char ch = words[0].charAt(j);
                alpha[ch-'a'] += 1;
        }
        int[] temp = new int[26];
        for(int i = 1; i < words.length; i++){
            Arrays.fill(temp,0);
            for(int j = 0; j < words[i].length(); j++){
                char ch = words[i].charAt(j);
                temp[ch-'a'] += 1;
            }
            for(int j = 0; j < 26; j++){
                alpha[j] = Math.min(alpha[j], temp[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(alpha[i] > 0){
                for(int j = 0; j < alpha[i]; j++){
                    ans.add(String.valueOf((char)(i+'a')));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n; i++){
            words[i] = sc.next();
        }
        List<String> ans = getCommon(words);
        System.out.println(ans);
        sc.close();
    }
}
