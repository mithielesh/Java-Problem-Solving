import java.util.*;
public class greedy2 {
    public static boolean isPossible(int[] arr,int n){
        int fiveCount=0, tenCount=0;
        for(int i=0;i<n;i++){
            if(arr[i]==5){
                fiveCount++;
            }
            else if(arr[i]==10){
                if(fiveCount>0){
                    fiveCount--;
                    tenCount++;
                }
                else{
                    return false;
                }
            }
            else if(arr[i]==20){
                if(tenCount>0 && fiveCount>0){
                    tenCount--;
                    fiveCount--;
                }
                else if(fiveCount>=3){
                    fiveCount -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        boolean isTrue = isPossible(arr,n);
        System.out.println(isTrue);
        sc.close();
    }
}
