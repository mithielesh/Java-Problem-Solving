import java.util.Scanner;
public class prob41 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int count=0;
        // for(int i=2;;i++){
        //     if(n>1){
        //         for(int j=2;j*j<=i;j++){
        //             if(i%j==0){
        //                 count++;
        //                 break;
        //             }
        //         }
        //         if(count==0){
        //             while(n%i==0){
        //                 System.out.print(i+" ");
        //                 n /= i;
        //             }
        //         }
        //         count = 0;
        //     }
        //     else{
        //         break;
        //     }
        // }
        for(int i=2;i*i<n;i++){
            while(n%i==0){
                System.out.print(i+" ");
                n /= i;
            }
        }
        if(n!=1){
            System.out.print(n);
        }
        sc.close();
    }
}
