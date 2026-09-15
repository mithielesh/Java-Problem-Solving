import java.util.Scanner;
public class prob44 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // int max = (a>=b&&a>=c) ? a : (b>=c) ? b : c;
        a = (int)Math.pow(a,2);
        b = (int)Math.pow(b,2);
        c = (int)Math.pow(c,2);
        if(a+b==c || b+c==a || a+c==b){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        sc.close();
    }
}
