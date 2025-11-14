import java.util.*;
public class recur05 {
    public static void powerSet(int index, int n, List<Integer> temp, List<List<Integer>> ans, int[] arr){
        if(index == n){
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        // Picking the element
        temp.add(arr[index]);
        powerSet(index+1,n,temp,ans,arr);
        temp.removeLast();

        // Not picking the element
        powerSet(index+1,n,temp,ans,arr);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        powerSet(0,n,temp,ans,arr);
        System.out.println("All the possible subsets are: ");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
