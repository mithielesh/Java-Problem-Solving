import java.util.Scanner;
public class prob9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the starting number: ");
        int low = sc.nextInt();
        System.out.print("Enter the ending number: ");
        int high = sc.nextInt();
        for(int i=low;i<=high;i++){
            int count = 0;
            for(int div=2;div*div<=i;div++){
                if(i%div==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.printf("%d\t",i);
            }
        }
        sc.close();
    }
}
