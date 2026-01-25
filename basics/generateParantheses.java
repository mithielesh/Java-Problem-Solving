import java.util.*;
public class generateParantheses {
    public static List<String> paranthesesCombo(int n){
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n*2,ans,sb,0,0,0);
        return ans;
    }
    public static void helper(int n, List<String> ans, StringBuilder sb, int openCount, int closeCount, int index){
        if(index == n){
            ans.add(sb.toString());
            return;
        }
        // Opening the bracket
        if(openCount < (n/2)){ // This check prevents from adding more open brackets than needed
            sb.append('(');
            helper(n,ans,sb,openCount+1,closeCount,index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
        // Closing the bracket
        if(openCount > closeCount){ // This prevents from closing unopened bracs
            sb.append(')');
            helper(n,ans,sb,openCount,closeCount+1,index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> ans = paranthesesCombo(n);
        System.out.println(ans);
        sc.close();
    }
}
