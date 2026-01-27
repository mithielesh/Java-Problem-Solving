import java.util.*;
public class stringSubsets {
    public static List<String> findSubstrings(String str){
        List<String> ans = new ArrayList<>();
        helper(str,ans,0);
        return ans;
    }
    public static void helper(String str, List<String> ans, int index){
        if(index >= str.length()){
            return;
        }
        for(int i = str.length(); i > index; i--){
            String s = str.substring(index,i);
            ans.add(s);
        }
        helper(str,ans,index+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> ans = findSubstrings(str);
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
