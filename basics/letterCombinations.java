import java.util.*;
public class letterCombinations {
    public static List<String> getCombinations(String num){
        HashMap<Character, String> tele = new HashMap<>();
        int alpha = 0;
        for(int i = 2; i <= 9; i++){
            StringBuilder s = new StringBuilder();
            int count = (i == 7 || i == 9) ? 4 : 3;
            for(int j = alpha; j < alpha + count; j++){
                s.append((char)(j+'a'));
            }
            alpha += count;
            char n = (char)(i+'0');
            tele.put(n,s.toString());
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(num,tele,ans,sb,0);
        return ans;
    }
    public static void helper(String num, HashMap<Character, String> tele, List<String> ans, StringBuilder sb, int index){
        if(index == num.length()){
            ans.add(sb.toString());
            return;
        }
        char ch = num.charAt(index);
        String temp = tele.get(ch);
        for(int i = 0; i < temp.length(); i++){
            sb.append(temp.charAt(i));
            helper(num,tele,ans,sb,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        List<String> ans = getCombinations(num);
        System.out.println(ans);
        sc.close();
    }
}
