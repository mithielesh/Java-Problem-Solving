import java.util.Scanner;
public class prob58 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = -1, b = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>=j){
                    int c = a+b;
                    System.out.print(c+" ");
                    a = b;
                    b = c;
                }
            }
            System.out.println();
        }
        System.out.println();
        a=0;b=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>=j){
                    System.out.print(a+" ");
                    int c = a+b;
                    a = b;
                    b = c;
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
