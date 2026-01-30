import java.util.*;
public class longestMountain {
    public static int getMountainLength(int[] arr){
        int n = arr.length;
        if(n < 3) return 0;
        
        int length = 0, max = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(i > 0 && i < n-1){
                if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                    int l = i-1, r = i+1;
                    length = 3; // Because the minimum mountain length will be three atleast
                    boolean lFlag = true, rFlag = true;
                    while(lFlag || rFlag){
                        if(l > 0 && arr[l] > arr[l-1] && lFlag){
                            length++;
                            l--;
                        }
                        else{
                            lFlag = false;
                        }
                        if(r < n-1 && arr[r] > arr[r+1] && rFlag){
                            length++;
                            r++;
                        }
                        else{
                            rFlag = false;
                        }
                    }
                    if(length > max){
                        max = length;
                    }
                    i = r;
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
        int length = getMountainLength(arr);
        System.out.println(length);
        sc.close();
    }
}
