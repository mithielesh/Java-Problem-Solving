import java.util.Scanner;
public class prob69 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println("The pattern:\n");
        for(int i=1;i<=n;i++){
            if(i==1){
                for(int j=1;j<=n;j++){
                    if(j<=(n/2)+1 || j==n){
                        System.out.print(" * ");
                    }
                    else{
                        System.out.print("   ");
                    }
                }
            }
            else if(i<=(n/2)){
                for(int j=1;j<=n;j++){
                    if(j==(n/2)+1 || j==n){
                        System.out.print(" * ");
                    }
                    else{
                        System.out.print("   ");
                    }
                }
            }
            else if(i==(n/2)+1){
                for(int j=1;j<=n;j++){
                    System.out.print(" * ");
                }
            }
            else if(i<n){
                for(int j=1;j<=n;j++){
                    if(j==1 || j==(n/2)+1){
                        System.out.print(" * ");
                    }
                    else{
                        System.out.print("   ");
                    }
                }
            }
            else if(i==n){
                for(int j=1;j<=n;j++){
                    if(j==1 || j>=(n/2)+1){
                        System.out.print(" * ");
                    }
                    else{
                        System.out.print("   ");
                    }
                }
            }
            System.out.println();
        }
    }
}
