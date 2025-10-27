import java.util.*;
public class recur09 {
    public static int printS(int[] brr, int n, int sum, int sumChecker, int index, int count){
        if(index==n){
            if(sumChecker == sum){
                return 1;
            }
            return 0;
        }
        // pick the element
        sumChecker += brr[index];
        int l = printS(brr,n,sum,sumChecker,index+1,count);
        sumChecker -= brr[index];

        // dont pick the element
        int r = printS(brr,n,sum,sumChecker,index+1,count);

        return l+r;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        } 
        int sum = sc.nextInt();
        int index=0, sumChecker=0;
        System.out.println(printS(arr,n,sum,sumChecker,index,0));
        sc.close();
    }
}
