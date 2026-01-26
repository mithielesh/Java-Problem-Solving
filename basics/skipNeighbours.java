import java.util.*;
public class skipNeighbours {
    public static List<String> neighbourSkip(String str){
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        helper(str,ans,s,0);
        return ans;
    }
    public static void helper(String str, List<String> ans, StringBuilder s, int index){
        // Let us try pick and not pick but in a different way
        if(index >= str.length()){
            ans.add(s.toString());
            return;
        }
        // The strategy of picking
        s.append(str.charAt(index));
        helper(str,ans,s,index+2);
        s.deleteCharAt(s.length()-1);

        // then the normal not pick
        helper(str,ans,s,index+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> ans = neighbourSkip(str);
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
