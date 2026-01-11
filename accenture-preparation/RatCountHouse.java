import java.util.*;
public class RatCountHouse {
    public static int houseCount(int r, int unit, int[] arr){
        int n = arr.length;
        int count = 0;
        if(n == 0) return -1;
        else{
            int checkSum = 0;
            boolean flag = false;
            for(int i = 0; i < n; i++){
                checkSum += arr[i];
                count++;
                if(checkSum >= unit){
                    flag = true;
                    break;
                }
            }
            if(flag) return count;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int unit = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int newUnit = r * unit;
        int count = houseCount(r,newUnit,arr);
        System.out.println(count);
        sc.close();
    }
}
