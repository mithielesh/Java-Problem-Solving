import java.util.Scanner;
public class prob67 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int sp=n/2,st=1;
        for(int i=1;i<=n;i++){
            if(i!=(n/2)+1){
                for(int j=1;j<=sp;j++){
                    System.out.print("   ");
                }
            }
            else{
                for(int j=1;j<=sp;j++){
                    System.out.print(" * ");
                }
            }
            for(int j=1;j<=st;j++){
                System.out.print(" * ");
            }
            System.out.println();
            if(i<=n/2){
                st++;
            }
            else{
                st--;
            }

        }
    }
}
