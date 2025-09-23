import java.util.Scanner;

public class prob7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        // Looping technique practice
        for (int j = 0; j < n; j++) {
            System.out.println("The number is: " + j);
        }
        int i = 0;
        while (i < n) {
            System.out.println("The number is: " + i);
            i++;
        }
        sc.close();
    }
}
