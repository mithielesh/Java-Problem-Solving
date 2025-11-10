// Basic Recursion Problems
import java.util.Scanner;
public class recurProb01 {
    

    public static void recurName(String name, int n, int count){
        if(count > n){
            return;
        }
        System.out.println(count+". My name is: "+name);
        count++;
        recurName(name, n, count);
    }


    public static void recurLinear(int n, int count){
        if(count > n){
            return;
        }
        System.out.println("The number is: "+count);
        count++;
        recurLinear(n,count);
    }


    public static void recurLinearReverse(int n, int count){
        if(count==0){
            return;
        }
        System.out.println("The number is: "+count);
        count--;
        recurLinearReverse(n,count);
    }


    public static void recurBackTrackLinear(int n, int count){
        if(count==0){
            return;
        }
        recurBackTrackLinear(n, count-1);
        /*By keeping the print line below the recursion call we have ensured that the 
         * call happens in the reverse order that is the last one first as the print also
         * sits in the stack waiting to be returned */
        System.out.println("The number is: "+count);
    }

    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        sc.close();
        System.out.println();
        recurName(name,n,1);
        System.out.println();
        recurLinear(n,1);
        System.out.println();
        recurLinearReverse(n,n);
        System.out.println();
        recurBackTrackLinear(n,n);
    }
}
