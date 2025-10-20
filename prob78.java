import java.util.*;
public class prob78 {
    public static int binToDec(String s, int n){
        int pow = 0;
        int ans = 0;
        for(int i=s.length()-1;i>=0;i--){
            int val = s.charAt(i) - '0';
            ans += val * (int)Math.pow(2,pow);
            pow++;
        }
        return ans;
    }
    public static int octToDec(String s, int n){
        int pow = 0;
        int ans = 0;
        for(int i=s.length()-1;i>=0;i--){
            int val = s.charAt(i) - '0';
            ans += val * (int)Math.pow(8,pow);
            pow++;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String num = sc.nextLine();
        System.out.print("Enter the base: ");
        int n = sc.nextInt();
        if(n==2){
            int result = binToDec(num,n);
            System.out.println("The Decimal equivalent of "+num+" is: "+result);
        }
        else if(n==8){
            int result = octToDec(num,n);
            System.out.println("The Decimal equivalent of "+num+" is: "+result);
        }   
        else{
            System.out.println("Invalid Input");
        }  
        sc.close();
    }
}
