import java.util.*;
public class prob77 {
    public static String convertBinary(int num, int n){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            int rem = num%2;
            sb.insert(0,rem);
            num /= 2;
        }
        return sb.toString();
    }
    public static String convertOctal(int num, int n){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            int rem = num%8;
            sb.insert(0,rem);
            num /= 8;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int number = sc.nextInt();
        System.out.print("Enter the base number: ");
        int n = sc.nextInt();
        if(n==10){
            System.out.println("The number of base "+n+" is: "+number);
        }else if(n==8){
            String result = convertOctal(number,n);
            System.out.println("The number of base "+n+" is: "+result);
        }
        else if(n==2){
            String result = convertBinary(number,n);
            System.out.println("The number of base "+n+" is: "+result);
        }
        else{
            System.out.println("Invalid Input");
        }
        sc.close();
    }
}
