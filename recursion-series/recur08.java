import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class recur08 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int start = 1;
        sum(ans,list,k,n,0,start);
        return ans;
    }
    public static void sum(List<List<Integer>> ans, List<Integer> list, int k, int n, int index, int start){
        if(n == 0 && index == k){
            
            ans.add(new ArrayList<>(list));
            return;
        }
        // Adding the numbers 1 through 9
        for(int i=start;i<10;i++){
            if(n >= i && !list.contains(i)){
                list.add(i);
                sum(ans,list,k,n-i,index+1,i+1);
                list.removeLast();
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        List<List<Integer>> ans = combinationSum3(k,n);
        if(ans.size() == 0){
            System.out.println("No combination possible");
        }
        else{
            for(int i=0;i<ans.size();i++){
                System.out.println(ans.get(i));
            }
        }
        sc.close();
    }
}
