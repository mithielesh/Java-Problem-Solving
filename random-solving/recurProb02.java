import java.util.*;
public class recurProb02 {

    // Parmeterised
    public static void recurParam(int n, long sum){
        if(n==0){
            System.out.println("The sum of the first n numbers is: "+sum);
            return;
        }
        recurParam(n - 1,sum + n);
    }

    // Functional
    public static int recurFunc(int n){
        if(n==0){
            return 0;
        }
        return n + recurFunc(n-1);
    }

    // Task 1: Factorial of n
    public static void factParam(int n, int ans){
        if(n==1){
            System.out.println("The factorial using the parameterized way is: "+ ans);
            return;
        }
        factParam(n-1,ans*n);
    }
    public static int factFunc(int n){
        if(n==1){
            return 1;
        }
        return n * factFunc(n -1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recurParam(n,0);
        System.out.println("The answer is: "+recurFunc(n));
        factParam(n,1);
        System.out.println("The factorial using the functional way is: "+ factFunc(n));
        sc.close();
    }
}
