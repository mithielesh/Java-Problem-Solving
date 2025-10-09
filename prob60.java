import java.util.Scanner;
public class prob60 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        // Method 1
        int sp=n/2,st=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<sp;j++){
                System.out.print("   ");
            }
            if(i<=n/2){
                 int temp = i;
                for(int j=0;j<st;j++){;
                    if(j<=st/2){
                        temp++;
                    }else{
                        temp--;
                    }
                    System.out.printf(" %d ",temp);
                }
            }
            else{
                int temp = n-i-1;
                for(int j=0;j<st;j++){
                    if(j<=st/2){
                        temp++;
                    }else{
                        temp--;
                    }
                    System.out.printf(" %d ",temp);
                }
            }
            if(i<n/2){
                st+=2;
                sp--;
            }
            else{
                sp++;
                st-=2;
            }
            System.out.println();
        }
        System.out.println();
        // Method 2
        int star=1,space=n/2,val=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=space;j++){
                System.out.print("   ");
            }
            int cval = val;
            for(int j=1;j<=star;j++){
                System.out.print(" "+cval+" ");
                if(j<=star/2){
                    cval++;
                }
                else{
                    cval--;
                }
            }
            if(i<=n/2){
                space--;
                star+=2;
                val++;
            }
            else{
                space++;
                star-=2;
                val--;
            }
            System.out.println();
        }
        sc.close();
    }
}
