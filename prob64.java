import java.util.Scanner;
public class prob64 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = encrypt(str);
        String ans = decrypt(result);
        System.out.println("The encrypted string: "+result);
        System.out.println("The decrypted string: "+ans);
        sc.close();
    }
    public static String encrypt(String str){
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for(int i=0;i<n;i++){
            if(i<n-1){
                if(str.charAt(i)>=97&&str.charAt(i)<=122){
                    if(str.charAt(i+1)>=65&&str.charAt(i+1)<=90){
                        sb.append(str.charAt(i+1)+""+str.charAt(i)+"*");
                        i++;
                    }
                    else{
                        sb.append(str.charAt(i));
                    }
                }
                else if(str.charAt(i)>=48&&str.charAt(i)<=57){
                    char ch = str.charAt(i);
                    sb.append('0');
                    sb.insert(0,ch);
                }
                else{
                    sb.append(str.charAt(i));
                }
            }
            else{
                if(str.charAt(i)>=48&&str.charAt(i)<=57){
                    char ch= str.charAt(i);
                    sb.setCharAt(i,'0');
                    sb.insert(0,ch);
                }
                else{
                    sb.append(str.charAt(i));
                }
            }
        }
        return sb.toString();
    }
    public static String decrypt(String result){
        StringBuilder sb = new StringBuilder();
        int n = result.length();
        for(int i=0;i<n;i++){
            if(i<n-2){
                if(result.charAt(i)>=65&&result.charAt(i)<=90){
                    if(result.charAt(i+1)>=97&&result.charAt(i+1)<=122){
                        if(result.charAt(i+2)=='*'){
                            sb.append(result.charAt(i+1)+""+result.charAt(i));
                            i+=2;
                        }
                        else{
                            sb.append(result.charAt(i));
                        }
                    }
                    else{
                            sb.append(result.charAt(i));
                        }
                }
                else{
                            sb.append(result.charAt(i));
                        }
            }
            else{
                            sb.append(result.charAt(i));
                        }
        }
        for(int i=sb.length()-1;i>0;i--){
            if(sb.charAt(i)=='0'){
                sb.setCharAt(i,sb.charAt(0));
                sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }
}
