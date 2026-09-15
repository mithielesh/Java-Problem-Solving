import java.util.Scanner;
public class prob49 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Method 1
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<=j){
                    System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        // Method 2
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                System.out.print("   ");
            }
            for(int j=1;j<=n-i+1;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }


        sc.close();
    }
}
