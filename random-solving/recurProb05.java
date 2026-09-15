import java.util.*;
public class recurProb05 {

    // Without using multiple recursion calls
    public static void fibonacci(int n1, int n2, int n){
        System.out.print(n1+" ");
        if(n==0){
            return;
        }
        fibonacci(n2,n1+n2,n-1);
    }

    //  With recursion calls
    /*What is happening is when it calls the value
     * for example let us consider that we are using fib(int n) where n=5
     * then what happens is it calls fib(4) and fib(3) 
     * it then becomes that till it reaches where both of the fib(2) returns n that is 0 and 1 itself 
     * It goes function by function so it goes first for fib(4) and then fib(3) */
    public static int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibonacci(0,1,n);
        int fib = fib(n);
        System.out.println("\n"+fib);
        sc.close();
    }
}
