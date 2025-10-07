import java.util.Scanner;
public class prob38 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n1 = a, n2 = b;
        while(true){
            int rem=a%b;
            if(rem==0){
                break;
            }
            a = b;
            b = rem;
        }
        int gcd = b;
        int lcm = (n1*n2)/gcd;
        System.out.println("The GCD is: "+gcd);
        System.out.println("The LCM is: "+lcm);
        sc.close();
    }
}
