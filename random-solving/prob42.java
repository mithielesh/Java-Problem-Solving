import java.util.Scanner;
public class prob42 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = String.valueOf(n);
        int size = str.length();
        int k = sc.nextInt();
        String ans = "";
        for(int i=k;i<size;i++){
            ans += str.charAt(i)+" ";
        }
        for(int i=0;i<k;i++){
            ans += str.charAt(i)+" ";
        }
        System.out.println(ans);
        sc.close();
    }
}
