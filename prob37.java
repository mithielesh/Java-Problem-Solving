import java.util.Scanner;
public class prob37 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the required streak value:");
        int k = sc.nextInt();
        System.out.println("Enter the upper bound:");
        int n = sc.nextInt();
        int totalCount=0;
        for(int i=2;i<=n;i++){
            int count=0;
            int div=1;
            for(int j=i;;j++){
                if(j%div==0){
                    count++;
                    div++;
                }
                else{
                    break;
                }
            }
            if(count==k){
                totalCount++;
            }
        }
        System.out.println("The total of count of numbers with the requied streak is: "+totalCount);
        sc.close();
    }
}
