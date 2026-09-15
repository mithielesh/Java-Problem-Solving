import java.util.Scanner;
public class prob24 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newStr = str.toLowerCase();
        int n = newStr.length();
        for(int i=0;i<n;i++){
            System.out.print(newStr.charAt(i)+" ");
        }
        sc.close();
    }
}
