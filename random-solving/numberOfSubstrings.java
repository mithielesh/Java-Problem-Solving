import java.util.*;
public class numberOfSubstrings {
    public static int countSubstrings(String s){
        int maxZ = (int)Math.sqrt(s.length());
        int count = 0;
        for(int i=0;i<s.length();i++){
            // Setting up the one and zero counter
            int zCount=0, oCount=0;
            for(int j=i;j<s.length();j++){
                char c = s.charAt(j);
                if(c == '1'){
                    oCount++;
                }else{
                    zCount++;
                }
                // This helps us in sureshot situations where the inner logic will never be true after thus we can safely stop it
                if(zCount <= maxZ){
                    // if they comply to the rules then increment count
                    if(oCount >= (zCount * zCount)){
                        count++;
                    }
                }else{
                    break;
                }
            }
        }
        return count;
    }
    public static int countSubstrings2(String s){
        int count = 0;
        int ones = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                ones++;
            }
            else if(s.charAt(i) == '0'){
                count += (ones) * (ones+1)/2;
                ones = 0;
                list.add(i);
            }
        }
        count += ones * (ones+1) / 2;
        
        for(int i=0;i<s.length();i++){
            for(int j=0;j<list.size();j++){

            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // int count = countSubstrings(s);
        int count2 = countSubstrings2(s);
        System.out.println(count2);
        sc.close();
    }
}
