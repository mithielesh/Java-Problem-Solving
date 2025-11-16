import java.util.*;
public class palindromepartitioningIII {
    public static void palindromePartition(String s, int n){
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(ans,list,s,0,n);
        if(ans.size() == 0){
            System.out.println("There are no valid answers with "+n+" cuts.");
        }else{
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
        }
    }
    public static void partition(List<List<String>> ans, List<String> list, String s, int partIndex, int n){
        if(partIndex == s.length()){
            if(list.size() == n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=partIndex;i<s.length();i++){
            if(isPalindrome(s,partIndex,i)){
                list.add(s.substring(partIndex,i+1));
                partition(ans,list,s,i+1,n);
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
        System.out.print("Enter the number of partitions: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the string: ");
        String s = sc.next();
        palindromePartition(s,n);
        sc.close();
    }
}
