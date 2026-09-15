import java.util.Scanner;
public class prob11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Method 1 using inbuilt methods

        /*String str = Integer.toString(n);
        int a = str.length();
        int count = 0;
        for(int i=0;i<a;i++){
            count++;
        }
        System.out.println("The count is: "+count);*/

        // Method 2 using manual division
        int temp = 0, count=0, i = 0;
        while(n!=0){
            temp += (n%10)*(Math.pow(10,i));
            n /= 10;
            count++;
            i++;
        }
        System.out.println("The count of digts in "+ temp +" is: "+count);
        sc.close();
    }
}
