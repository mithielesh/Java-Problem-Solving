import java.util.Scanner;
public class prob48 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Method 1
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+j>=n-1){
                    System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        // Method 2
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print("   ");
            }
            for(int j=0;j<i+1;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
