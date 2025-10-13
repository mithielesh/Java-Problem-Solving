import java.util.Scanner;
public class prob65 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int sp = 0,st=n;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("   ");
            }
            for(int j=1;j<=st;j++){
                System.out.print(" * ");
            }
            System.out.println();
            if(i<=n/2){
                st-=2;
                sp++;
            }
            else{
                st+=2;
                sp--;
            }
        }
    }
}
