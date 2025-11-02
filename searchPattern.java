import java.util.*;
public class searchPattern {
    public static List<Integer> search(String txt, String pat){
        List <Integer> ans = new ArrayList<>();
        if(pat.length() > txt.length()) return ans;
        else if(txt.indexOf(pat) == -1) return ans;
        else{
            char[] mainString = txt.toCharArray();
            char[] patString = pat.toCharArray();
            int base = 31;
            int power = pat.length() -1;
            // Setting up the numerical sumChecker from the patString
            long sumChecker = 0;
            for(int i=0;i<patString.length;i++){
                sumChecker += ((patString[i] - 'a') * (int)Math.pow(base,power)) % ((int)Math.pow(10,9) +7);
                power--;
            }

            // Set up the sum checker to check now just need to go forward with the checking
            long val=0;
            power = pat.length()-1;
            for(int i=0;i<patString.length;i++){
                val += ((mainString[i] - 'a') * (int)Math.pow(base,power)) % ((int)Math.pow(10,9) +7);
                power--;
            }
            if(val == sumChecker){
                ans.add(0);
                if(pat.length() == txt.length()) return ans;
            }
            power = pat.length()-1;
            for(int i=1;i<=txt.length() - pat.length();i++){
                val -= ((mainString[i-1] - 'a') * (int)Math.pow(base,power)) % ((int)Math.pow(10,9) +7);
                val *= base;
                val += (mainString[i + pat.length() - 1] - 'a') % ((int)Math.pow(10,9) +7);
                if(val == sumChecker){
                    ans.add(i);
                }
            }   
            return ans;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String pat = sc.nextLine();
        List<Integer> search = search(txt,pat);
        System.out.println(search);
        sc.close();
    }
}
