import java.util.Scanner;
public class prob16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting range: ");
        int m = sc.nextInt();
        System.out.print("Enter closing range: ");
        int n = sc.nextInt();
        int a,b,c,d,e;
        while(m<=n){
            a = m%10;
            b = m/10;
            c = a+b;
            d = a*b;
            e = c+d;
            if(e==m){
                System.out.println(m);
            }
            m++;
        }
        sc.close();
    }
}
