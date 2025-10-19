// Calculating frequency
import java.util.*;
public class prob76 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        String num = sc.nextLine();
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            arr[i] = 0;
        }
        HashMap <Integer, Integer> map = new HashMap<>();

        // Array Method
        for(int i=0;i<num.length();i++){
            int val = (int)num.charAt(i) - '0';
            arr[val-1]++;
        }

        // HashMap Method
        for(int i=0;i<num.length();i++){
            int val = num.charAt(i)-'0';
            if(map.containsKey(val)){
                int count = map.get(val)+1;
                map.put(val,count);
            }
            else{
                map.put(val,1);
            }
        }
        System.out.println("Enter the value to find: ");
        int k = sc.nextInt();
        System.out.println("The hash map answer is: "+map.get(k));
        System.out.println("The array answer is: "+arr[k-1]);
        sc.close();
    }
}
