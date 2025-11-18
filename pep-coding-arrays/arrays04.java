import java.util.*;
public class arrays04 {
    public static void sumOfTwoArrays(int[] arr, int n1, int[] brr, int n2){
        // I am considering using the naive method here of first equalizing the arrays
        int len = n1;
        if(n1 > n2){
            int[] newBrr = equalizeArray(brr,n1,n2);
            len = n1;
            calculateSum(arr,newBrr,len);
        }
        else if(n2 > n1){
            int[] newArr = equalizeArray(arr,n2,n1);
            len = n2;
            calculateSum(brr,newArr,len);
        }
    }
    public static int[] equalizeArray(int[] arr, int n, int m){
        int diff = n - m;
        int[] newArr = new int[n];
        for(int i=0;i<n;i++){
            if(i < diff){
                newArr[i] = 0;
            }
            else{
                newArr[i] = arr[i-diff];
            }
        }
        return newArr;
    }
    public static void calculateSum(int[] arr,int[] brr,int len){
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        for(int i=len-1;i>=0;i--){
            int sum = arr[i] + brr[i] + carry;
            if(carry == 1) carry = 0;
            if(i==0){
                list.add(sum);
                continue;
            }
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
            list.add(sum);
        }
        Collections.reverse(list);
        System.out.println("The sum of the two arrays is:");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
    public static String efficientSumOfTwoArrays(int n, int m, int[] arr, int[] brr){
        int i = n-1;
        int j = m-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0){
            int sum = arr[i] + brr[j] + carry;
            if(carry == 1) carry = 0;
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
            sb.append(sum);
            i--;
            j--;
        }
        // Considering that brr got over
        while(i >= 0){
            int sum = arr[i] + carry;
            if(carry == 1) carry = 0;
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
            sb.append(sum);
            i--;
        }
        // Considering that arr got over
        while(j >= 0){
            int sum = brr[j] + carry;
            if(carry == 1) carry = 0;
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
            sb.append(sum);
            j--;
        }
        if(carry == 1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr = new int[n1];
        for(int i=0;i<n1;i++){
            arr[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] brr = new int[n2];
        for(int i=0;i<n2;i++){
            brr[i] = sc.nextInt();
        }
        sumOfTwoArrays(arr,n1,brr,n2);
        String ans = efficientSumOfTwoArrays(n1,n2,arr,brr);
        System.out.println("\nThe other output is also: "+ans);
        sc.close();
    }
}
