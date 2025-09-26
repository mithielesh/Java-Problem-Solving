import java.util.Scanner;
public class prob22 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int a = Math.abs(n-n1);
        int b = Math.abs(n-n2);
        int c = Math.abs(n-n3);
        if((a<b&&a<c)||(a==b||a==c)&&n1>=n){
            System.out.println(n1);
        }
        else if((b<c)||(b==c)&&n2>=n){
            System.out.println(n2);
        }
        else{
            System.out.println(n3);
        }
        sc.close();
    }
}
