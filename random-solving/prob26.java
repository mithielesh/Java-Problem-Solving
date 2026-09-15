import java.util.Scanner;
public class prob26 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int count=0,val=0;
        for(int i=n+1; ;i++){
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                val = i;
                break;
            }
            count = 0;
        }
        System.out.println("The next prime number is: "+val);
        sc.close();
    }
}

