import java.util.Scanner;

public class prob39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        // Use a simple turn counter or a boolean flag
        int turn = 0; // 0 for Alice, 1 for Bob

        while (true) {
            if (turn == 0) { // Alice's Turn
                int take = gcd(a, n);
                if (n < take) {
                    // Alice cannot take the required amount, so Bob wins.
                    System.out.println("1");
                    break;
                }
                n -= take;
                turn = 1; // Switch to Bob's turn
            } else { // Bob's Turn
                int take = gcd(b, n);
                if (n < take) {
                    // Bob cannot take the required amount, so Alice wins.
                    System.out.println("0");
                    break;
                }
                n -= take;
                turn = 0; // Switch to Alice's turn
            }
        }
    }

    // Correct and safe GCD function
    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}