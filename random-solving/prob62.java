import java.util.Scanner;
public class prob62 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println();
        int st=1, st2=1,sp=2*(n-2)+1;
        //System.out.println(sp);
        for(int i=0;i<n;i++){
            for(int j=1;j<=st;j++){
                System.out.print(" "+j+" ");
            }
            for(int j=0;j<sp;j++){
                System.out.print("   ");
            }
            for(int j=st2;j>=1;j--){
                System.out.print(" "+j+" ");
            }
            System.out.println();
            sp-=2;
            st++;
            if(i<n-2){
                st2++;
            }
        }
        sc.close();
    }
}
