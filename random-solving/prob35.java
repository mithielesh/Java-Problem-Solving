import java.util.Scanner;
public class prob35 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int count=0;
        count += amount/100;
        amount = amount%100;
        count += amount/50;
        amount = amount%50;
        count += amount/10;
        amount = amount%10;
        count += amount/5;
        amount = amount%5;
        count += amount/2;
        amount = amount%2;
        count += amount/1;
        amount = amount%1;
        System.out.println(count);
        sc.close();
    }
}
