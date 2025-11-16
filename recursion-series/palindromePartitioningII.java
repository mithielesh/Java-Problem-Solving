import java.util.*;
// The goal is to find the minimum cuts for getting an array full of substrings, if 1 then it is the best
public class palindromePartitioningII {
    public static void palindromePartition(String s){
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(ans,list,s,0);
        int min = s.length();
        int index = 0;
        for(int i=0;i<ans.size();i++){
            if(ans.get(i).size() < min){
                min = ans.get(i).size();
                index = i;
            }
        }
        System.out.println(ans.get(index));
        System.out.println("The minimum number of cuts is: "+(min-1));
    }
    public static void partition(List<List<String>> ans, List<String> list, String s, int partIndex){
        if(partIndex == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=partIndex;i<s.length();i++){
            if(isPalindrome(s,partIndex,i)){
                list.add(s.substring(partIndex,i+1));
                partition(ans,list,s,i+1);
                list.removeLast();
            }
        }
    }
    public static boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        palindromePartition(s);
        sc.close();
    }
}
