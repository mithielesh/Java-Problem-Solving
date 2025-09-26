import java.util.Scanner;
 public class prob19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        for(int i=1;i<=10;i++){
            if(i==5 || i==6){
                continue;
            }
            else{
                System.out.println(n+"x"+i+"="+n*i);
            }
        }
        sc.close();
    }
}