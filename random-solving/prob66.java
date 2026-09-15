import java.util.Scanner;
public class prob66 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int sp = 2*(n/2), st = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=st;j++){
                System.out.print(" * ");
            }
            for(int j=1;j<=sp;j++){
                System.out.print("   ");
            }
            for(int j=1;j<=st;j++){
                System.out.print(" * ");
            }
            System.out.println();
            if(i<=n/2){
                sp-=2;
                st++;
            }
            else{
                sp+=2;
                st--;
            }
        }
    }
}
