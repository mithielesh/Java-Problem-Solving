import java.util.Scanner;
public class prob14 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int temp = 0, i = 1;
        while(n!=0){
            int a  = n%10;
            temp += i*((int)Math.pow(10,a-1));
            i++;
            n /= 10;
        }
        System.out.println("The inversed number is: " +temp);
        sc.close();
    }
}
