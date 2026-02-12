import java.util.*;
public class stringCompression {
    public static int compressString(char[] chars){
        int n = chars.length;
        int index = 0;
        int read = 1, write = 0;
        for(int i = 1; i < n; i++){
            if(chars[i] == chars[i-1]){
                read++;
            }
            else{
                index++;
                if(read > 1){
                    String temp = String.valueOf(read);
                    for(int j = 0; j < temp.length(); j++){
                        write++;
                        chars[write] = temp.charAt(j);
                        index++;
                    }
                }
                write++;
                chars[write] = chars[i];
                read = 1;
            }
        }
        if(read > 1){
            write++;
            String temp = String.valueOf(read);
            for(int j = 0; j < temp.length(); j++){
                chars[write] = temp.charAt(j);
                write++;
                index++;
            }
        }
        index++;
        return index;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        int index = compressString(chars);
        for(int i = 0; i < index; i++){
            System.out.print(chars[i]);
        }
        sc.close();
    }
}
