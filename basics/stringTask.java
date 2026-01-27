import java.util.*;
public class stringTask {
    public static String converter(String str){
        str = str.toLowerCase();
        StringBuilder s = new StringBuilder();
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(!set.contains(c)){
                s.append("."+c);
            }
        }
        return s.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String convert = converter(str);
        System.out.println(convert);
        sc.close();
    }
}
