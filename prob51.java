import java.util.Scanner;
public class prob51 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int st = n/2;
        int sp = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=st;j++){
                System.out.print(" * ");
            }
            for(int j=0;j<sp;j++){
                System.out.print("   ");
            }
            for(int j=0;j<=st;j++){
                System.out.print(" * ");
            }
            if(i<=n/2){
                sp+=2;
                st--;
            }
            else{
                sp-=2;
                st++;
            }
            System.out.println();
        }

        sc.close();
    }
}
