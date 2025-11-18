import java.util.*;
public class arrays05 {
    public static void sum(List<Integer> arr, List<Integer> brr, int n, int m){
        List<Integer> ans = new ArrayList<>();
        int len = (n >= m) ? n : m;
        int carry = 0;
        while(len >= 0){
            int sum = carry;
            if(n >= 0){
                sum += arr.get(n);
            }
            if(m >= 0){
                sum += brr.get(m);
            }
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            n--;
            m--;
            len--;
        }
        if(carry != 0){
            ans.add(carry);
        }
        System.out.print("The sum of the two arrays is: ");
        for(int i=ans.size() - 1; i >= 0; i--){
            System.out.print(ans.get(i));
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of first array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        System.out.print("Enter the size of second array: ");
        int m = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        List<Integer> brr = new ArrayList<>();
        for(int i=0;i<m;i++){
            brr.add(sc.nextInt());
        }
        sum(arr,brr,n-1,m-1);
        sc.close();
    }
}
