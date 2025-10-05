import java.util.Scanner;
public class prob34{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = "";
        for(int j=0;;j++){
            char c = sc.next().charAt(0);
            String temp = "";
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)<=c){
                    temp+=str.charAt(i);
                }
            }
            System.out.println(temp);
            if(temp.length()==1){
                ans += temp;
                break;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}