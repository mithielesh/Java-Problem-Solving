import java.util.*;
public class greedy1 {
    public static int maxCount(int[] arr, int[] brr, int n){
        int count=0;
        Arrays.sort(arr);
        Arrays.sort(brr);
        int r = 0;
        for(int l=0;l<n;l++){
            if(brr[l] >= arr[r]){
                count++;
                r++;                                      
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] gf = new int[n];
        int[] cookie = new int[n];
        for(int i=0;i<n;i++){
            gf[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            cookie[i] = sc.nextInt();
        }
        sc.close();
        int count = maxCount(gf,cookie,n);
        System.out.println(count);
    }
}
