import java.util.*;
public class kPermutationOptimal {
    public static String permuteK(int n, int k){
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(i+1);
        }
        StringBuilder s = new StringBuilder();
        k--;
        while(arr.size() != 0){
            // We keep updating the fact in order to get the value we are trying to compute
            n--;
            int f = fact(n);
            // For ordered pairs of the permutations we have a fixed way in which they appeaer
            int ind = k/f;
            // Need to keep updating the value as we keep finding and close down on the vaalue
            k = k%f;
            s.append(arr.get(ind));
            arr.remove(ind);
        }
        return s.toString();
    }
    public static int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n * fact(n-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String ans = permuteK(n,k);
        System.out.print(ans);
        sc.close();
    }
}
