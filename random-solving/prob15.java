import java.util.Scanner;
public class prob15 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.print("Enter the rotation should be done by: ");
        int k = sc.nextInt();
        int temp = n;
        // Get the count or the number of digits in the integer
        int count = 0;
        while(temp!=0){
            temp /= 10;
            count++;
        }
        // Saving time preventing unnecessary looping
        k = k%count;
        if(k<0){
            k += count;
        }
        //Set the multiplier and divisor for getting the answer
        int div = 1;
        int mult = 1;
        for(int i=0;i<count;i++){
            if(i<k){
                div = div*10;
            }
            else{
                mult = mult*10;
            }
        }

        //Getting the answer
        int q = n/div;
        int r = n%div;
        r = (r*mult)+q;
        System.out.println("The rotated number is: "+r);
        sc.close();
    }
}
