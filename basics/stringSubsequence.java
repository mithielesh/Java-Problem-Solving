import java.util.*;

public class stringSubsequence {
    public static List<String> findSubsequences(String str){
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        helper(str,ans,s,0);
        return ans;
    }
    public static void helper(String str, List<String> ans, StringBuilder s, int index){
        // Use the pick and not pick with backtracking
        if(index == str.length()){
            ans.add(s.toString());
            return;
        }
        // pick something
        s.append(str.charAt(index));
        helper(str,ans,s,index+1);
        s.deleteCharAt(s.length() - 1);

        // not pick something
        helper(str,ans,s,index+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> ans = findSubsequences(str);
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
