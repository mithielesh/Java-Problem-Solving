import java.util.Scanner;
public class prob18 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,i,j,k,l;
        System.out.print("Enter the number of rows: ");
        n = sc.nextInt();
        for(i=1;i<=n;i++){
            for(j=i;j<n;j++){
                System.out.print("b");
            }
            for(k=1;k<(2*i);k++){
                System.out.print("*");
            }
            for(l=i;l<n;l++){
                System.out.print("b");
            }
            System.out.println();
        }
        sc.close();
    }
}