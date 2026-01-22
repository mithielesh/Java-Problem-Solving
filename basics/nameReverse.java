import java.util.*;
public class nameReverse {
    public static void reverseName(char[] name, int l, int r){
        if(l >= r){
            return;
        }
        swap(name,l,r);
        reverseName(name,l+1,r-1);
    }
    public static void swap(char[] name, int l, int r){
        char temp = name[l];
        name[l] = name[r];
        name[r] = temp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        char[] nameArr = name.toCharArray();
        reverseName(nameArr,0,name.length()-1);
        String ans = new String(nameArr);
        System.out.println(ans);
        sc.close();
    }
}
