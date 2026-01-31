import java.util.*;
public class plusOne {
    private static int[] addOne(int[] arr){
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            int val = arr[i];
            if(i == arr.length - 1){
                val += 1;
            }
            if(carry == 1){
                val += 1;
                carry -= 1;
            }
            if(val == 10){
                carry = 1;
                list.add(0);
            }
            else{
                list.add(val);
            }
        }
        if(carry == 1) list.add(1);
        int[] ans = new int[list.size()];
        int ind = 0;
        for(int i = list.size()-1; i >= 0; i--){
            ans[ind] = list.get(i);
            ind++;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] ans = addOne(arr);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i]+" ");
        }
        sc.close();
    }
}
