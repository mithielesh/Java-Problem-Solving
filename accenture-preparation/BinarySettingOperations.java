import java.util.*;
public class BinarySettingOperations {
    public static int binarySettings(String str){
        if(str == null) return -1;
        int n = str.length();

        if(n == 0) return -1;
        if(n == 1) return Integer.parseInt(str);

        int ans = 0;
        // Muhehehe
        for(int i = 0; i < n; i++){
            
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int ans = binarySettings(str);
        System.out.println(ans);
        sc.close();
    }
}
