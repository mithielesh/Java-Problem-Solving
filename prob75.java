// Using Dynamic Programming to solve fibonacci problems
import java.util.*;
public class prob75 {
    public static int fibonacci(int n){
        List <Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        for(int i=2;i<n;i++){
            int newVal = dp.get(i-2) + dp.get(i-1);
            dp.add(newVal);
        }
        return dp.get(n-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int result = fibonacci(n);
        System.out.println("The result is: "+ result);
        sc.close();
    }
}
