import java.util.*;
public class prob74{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int len = 2*n-1;
        int min,min1,min2;
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                min1 = i<=len-i ? i-1 : len-i;
                min2 = j<=len-j ? j-1 : len-j;
                min = min1<=min2 ? min1 : min2;
                System.out.print(n-min+" ");
            }
            System.out.println();
        }
    }
}