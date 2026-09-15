import java.util.Scanner;
public class prob10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of series you want printed: ");
        int n = sc.nextInt();
        int n1 = 0, n2 = 1;

        // Method 1

        /*System.out.println(n1);
        System.out.println(n2);
        for(int i=2;i<=n;i++){
            int temp = n1 + n2;
            System.out.println(temp);
            n1 = n2;
            n2 = temp;
        }*/

        // Method 2

        for(int i=0;i<=n;i++){
            System.out.println(n1);
            int temp = n1+n2;
            n1 = n2;
            n2 = temp;
        }
        sc.close();
    }
}
