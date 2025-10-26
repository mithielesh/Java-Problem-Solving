import java.util.*;
public class recur04 {
    public static boolean isPalindrome(int i, int n,char[] arr){
        if(i >= n/2){
            return true;
        }
        if(arr[i] != arr[n-i-1]){
            return false;
        }else{
            return isPalindrome(i+1,n,arr);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        boolean flag = isPalindrome(0,chars.length,chars);
        if(flag==true){
            System.out.println("It is a palindrome");
        }else{
            System.out.println("Not a palindrome");
        }
        sc.close();
    }
}
