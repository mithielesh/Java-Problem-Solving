import java.util.Scanner;

public class prob3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int sum = 0;
            for (int j = 0; j < c; j++) {
                sum += (int) Math.pow(2, j) * b;
                System.out.print(a + sum+ " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
