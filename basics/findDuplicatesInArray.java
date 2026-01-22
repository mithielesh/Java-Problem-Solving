import java.util.*;

public class findDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] arr){
        List<Integer> duplicates = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int val = Math.abs(arr[i]);
            if(arr[val - 1] < 0){
                duplicates.add(val);
            }
            else{
                arr[val - 1] = -arr[val - 1];
            }
        }
        return duplicates;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> duplicates = findDuplicates(arr);
        for(int i = 0; i < duplicates.size(); i++){
            System.out.println(duplicates.get(i)+" ");
        }
        sc.close();
    }
}
