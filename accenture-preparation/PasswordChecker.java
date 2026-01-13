import java.util.*;
public class PasswordChecker {
    public static int checkPass(String str){
        // This is written with the assumption that none of the strings are important
        int n = str.length();
        // Create flags to check for all the cases
        boolean numFlag = false, alphaFlag = false;
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            // First value should not be a number
            if(i == 0 && (ch >= '0' && ch <= '9')){
                return 0;
            }
            // There should be no / or spaces
            if(ch == '/' || ch == ' ') return 0;

            if(!alphaFlag){
                if(ch >= 'A' && ch <= 'Z'){
                    alphaFlag = true;
                }
            }
            if(!numFlag){
                if(ch >= '0' && ch <= '9'){
                    numFlag = true;
                }
            }
        }
        if(!alphaFlag || !numFlag || n < 4) 
            return 0;
        return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int checkStatus = checkPass(str);
        if(checkStatus == 1){
            System.out.println("The password is valid");
        }else{
            System.out.println("The password is invalid");
        }
        sc.close();
    }
}
