import java.util.*;
public class reverseNumber {
    public static int reverser(int n){
        // this is with the assumption that there are no leading or trailing zeroes in the number
  
        int count = 0;
        int temp = n;
        while(temp != 0){
            temp /= 10;
            count++;
        }
        int reversedNumber = 0;
        while(n != 0){
            int val = n % 10;
            reversedNumber += (int)Math.pow(10,--count) * val;
            n /= 10;
        }
        return reversedNumber;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = reverser(n);
        System.out.println(ans);
        sc.close();
    }
}
