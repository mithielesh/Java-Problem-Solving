import java.util.Scanner;
public class prob38 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(true){
            int rem=a%b;
            if(rem==0){
                break;
            }
            a = b;
            b = rem;
        }
        System.out.println(b);
        sc.close();
    }
}
