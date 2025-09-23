import java.util.Scanner;

public class prob12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("The numbers are: ");
        int digit = n, count = 0;
        while (digit != 0) {
            digit /= 10;
            count++;
        }
        int div = (int) Math.pow(10, count - 1);
        while (div != 0) {
            int q = n / div;
            System.out.println(q);
            n = n % div;
            div /= 10;
        }
        sc.close();
    }
}
