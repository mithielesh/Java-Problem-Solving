import java.util.*;
public class arrays06 {
    // need to follow the rule of keeping negative carries and always assume that the array brr is larger than arr
    // atleast for our case we are assuming thar
    public static int[] difference(List<Integer> arr, List<Integer> brr, int n, int m){
        if(m > n){
            padding(arr,m-n);
            n = m;
        }
        int max = Math.max(n,m);
        int[] diff = new int[max];
        int carry = 0;
        while(max > 0){
            int ans = carry;
            if(m > 0){
                ans += brr.get(m-1);
            }
            if(n > 0){
                if(ans >= arr.get(n-1)){
                    ans -= arr.get(n-1);
                    carry = 0;
                }
                else{
                    ans += 10;
                    ans -= arr.get(n-1);
                    carry = -1;
                }
            }
            diff[max-1] = ans;
            max--;
            m--;
            n--;
        }
        if(carry == -1){
            return null;
        }
        return diff;
    }
    public static void padding(List<Integer> arr, int diff){
        for(int i=0;i<diff;i++){
            arr.add(0,0);
        }
    }

    // Another method without padding which is much cleaner
    public static void subtractArrays(List<Integer> arr, List<Integer> brr, int n, int m){
        int max = Math.max(m,n);
        int[] diff = new int[max];
        int carry = 0;
        while(max > 0){
            int a = (n > 0) ? arr.get(n-1) : 0;
            int b = brr.get(m-1);
            int ans = b - a + carry;
            if(ans < 0){
                ans += 10;
                carry = -1;
            }else{
                carry = 0;
            }
            diff[max-1] = ans;
            max--;
            m--;
            n--;
        }
        if(carry == -1){
            System.out.println("Subtracting is not possible.");
        }else{
            int firstNumIndex = 0;
            for(int i=0;i<diff.length;i++){
                if(diff[i] == 0) continue;
                else{
                    firstNumIndex = i;
                    break;
                }
            }
            System.out.println("The difference between the two arrays is: ");
            for(int i=firstNumIndex;i<diff.length;i++){
                System.out.print(diff[i]);
            }
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
        // int[] diff = difference(arr,brr,n,m);
        // if(diff == null){
        //     System.out.println("It is not possible to subtract them.");
        // }
        // else{
        //     int firstNumIndex = 0;
        //     for(int i=0;i<diff.length;i++){
        //         if(diff[i] == 0) continue;
        //         else{
        //             firstNumIndex = i;
        //             break;
        //         }
        //     }
        //     System.out.println("The difference between the two arrays is: ");
        //     for(int i=firstNumIndex;i<diff.length;i++){
        //         System.out.print(diff[i]);
        //     }
        // }
        subtractArrays(arr,brr,n,m);
        sc.close();
    }
}
