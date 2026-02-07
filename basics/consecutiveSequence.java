import java.util.*;
public class consecutiveSequence {
    public static int getSequenceCount(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        int max = 1;
        for(int item : set){
            int count = 1;
            if(set.contains(item-1)){
                continue;
            }
            else{
                int num = item;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                if(count > max){
                    max = count;
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int count = getSequenceCount(arr);
        System.out.println(count);
        sc.close();
    }
}
