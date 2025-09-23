import java.util.Scanner;
public class prob8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of testcases: ");
        int t = sc.nextInt();
        // Method one
        /*for(int i=0;i<t;i++){
            System.out.print("Enter a number: ");
            int n = sc.nextInt();
            boolean flag = true;
            if(n<=1){
                flag = false;
            }
            else if(n<=3){
                flag = true;
            }
            else if(n%2==0 || n%3==0){
                flag = false;
            }
            else{
                int j = 5;
                while(j*j<=n){
                    if(n%j==0 || n%(j+2)==0){
                        flag = false;
                        break;
                    }
                    else{
                        j += 6;
                    }
                }
            }
            if(flag==true){
                System.out.printf("The number %d is prime\n",n);
            }
            else{
                System.out.printf("The number %d is not prime\n",n);
            }
        }*/
        
        // Method 2
        for(int i=0;i<t;i++){
            System.out.print("Enter a number: ");
            int n = sc.nextInt();
            int count = 0;
            for(int div = 2;div*div<=n;div++){
                if(n%div==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.println("It is prime");
            }
            else{
                System.out.println("It is not prime");
            }
        }
        sc.close();
    }
}
