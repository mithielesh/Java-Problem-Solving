import java.util.Scanner;
public class prob13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int temp = n;
        int count = 0;
        while(n!=0){
            n /= 10;
            count++;
        }
        int rev = 0;
        int div = (int)Math.pow(10,count-1);
        while(temp!=0){
            int a = temp%10;
            rev += a*div;
            temp /= 10;
            div /= 10;
        }
        System.out.println("The reversed string is: "+rev);
        sc.close();
    }
}
