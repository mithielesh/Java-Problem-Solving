import java.util.Scanner;
public class prob2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double d = sc.nextDouble();
        sc.nextLine(); //Used to remove the \n that is stored in the input buffer
        String s = sc.nextLine();
        System.out.printf("String: %s\n", s);
        System.out.printf("Integer: %d\n", n);
        System.out.printf("Double: %.2f\n", d);
        System.out.println("String: "+s);
        sc.close();
    }
}
