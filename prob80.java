import java.util.*;
public class prob80 {
    public static void binAddition(String a, String b){

    }
    public static void octAddition(String a, String b){
        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(b);
        int carry = 0;
        int min = (a.length()<=b.length()) ? a.length() : b.length();
        while(min>0){
            
        }
    }
    public static int decAddition(String a, String b){
        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(b);
        int result = n1 + n2;
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String a = sc.nextLine();
        System.out.print("Enter the second number: ");
        String b = sc.nextLine();
        System.out.print("Enter the base: ");
        int base = sc.nextInt();
        if(base==2){

        }else if(base==8){

        }else if(base==10){
            int result = decAddition(a,b);
            System.out.println(a+" + "+b+" = "+result);
        }else{
            System.out.println("Invalid Input");
        }
        sc.close();
    }
}
