import java.util.*;
public class mobileNumberCharacters {
    public static void phoneCombination(String str){
        HashMap<Character, String> map = new HashMap<>();
        int j = 0;
        for(char i='2';i<='9';i++){
            int counter = 0;
            StringBuilder s = new StringBuilder();
            while(true){
                if(i == '7' || i == '9'){
                    if(counter == 4) break;
                }else{
                    if(counter == 3) break;
                }
                s.append((char)('a'+j));
                j++;
                counter++;
            }
            map.put(i,s.toString());
        }
        for(String s : map.values()){
            System.out.println(s);
        }
        List<String> ans = new ArrayList<>();
    }

    public static void recur(){
        // if(ind == str.length()){
            
        // }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        phoneCombination(str);
        sc.close();
    }
}
