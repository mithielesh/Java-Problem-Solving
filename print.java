import java.util.Scanner;
public class print {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String mithu = scanner.next();
        int age = scanner.nextInt();
        System.out.println("My name is " + mithu + " and my age is " + age);
        scanner.close();
    }
}
