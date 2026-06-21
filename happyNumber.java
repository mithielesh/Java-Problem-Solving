import java.util.*;
public class happyNumber {
    private static boolean isHappy(int n) {
        if(n == 1 || n == 7) {
            return true;
        }
        if(n >= 2 && n <= 9) {
            return false;
        }
        int fast = n, slow = n;
        while(true) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if(fast == 1) {
                return true;
            }
            else if(fast == slow) {
                break;
            }
        }
        return false;
    }
    private static int getNext(int n) {
        int sum = 0;
        while(n != 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isHappy(n)) {
            System.out.println("Happy number");
        }
        else {
            System.out.println("Not a happy number");
        }
    }
}