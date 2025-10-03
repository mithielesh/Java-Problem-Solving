import java.util.Scanner;
public class prob32{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String key = "qwertyuiopasdfghjkl;zxcvbnm,./";
        String original = "";
        System.out.println("Enter a character");
        char c = sc.next().charAt(0);
        sc.nextLine();
        System.out.println("Enter the string");
        String str = sc.nextLine();
        if(c=='R'){
            for(int i=0;i<str.length();i++){
                for(int j=0;j<key.length();j++){
                    if(key.charAt(j)==str.charAt(i)){
                        if(j>0){
                            original += key.charAt(j-1);
                        }
                        else{
                            original += key.charAt(key.length()-1);
                        }
                    }
                }
            }
        }
        else if(c=='L'){
            for(int i=0;i<str.length();i++){
                for(int j=0;j<key.length();j++){
                    if(key.charAt(j)==str.charAt(i)){
                        if(j<key.length()-1){
                            original += key.charAt(j+1);
                        }
                        else{
                            original += key.charAt(0);
                        }
                    }
                }
            }
        }
        System.out.println("The original message");
        for(int i=0;i<original.length();i++){
            System.out.print(original.charAt(i));
        }
        sc.close();
    }
}
