import java.util.*;
public class prob73 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h1=2*(n-1), ch1=n+(n-1)-1, ch2=n+(n-1)-1, h2=ch2+1;
        int lettCount=1;
        for(int i=1;i<2*n;i++){
            for(int j=0;j<h1;j++){
                System.out.print("-");
            }
            int counter=0;
            int val = 97 +n-1;
            char ch = (char)(97 + n - 1);
            for(int j=ch1;j<=ch2;j++){
                if(j%2==0){
                    System.out.printf("%c",ch);
                    counter++;
                    if(counter<=(lettCount/2)){
                        val--;
                        ch = (char)(val);
                    }
                    else{
                        val++;
                        ch = (char)(val);
                    }
                }
                else{
                    System.out.print("-");
                }
            }
            for(int j=h2;j<=4*(n-1);j++){
                System.out.print("-");
            }
            if(i<n){
                h1-=2;
                h2+=2;
                ch1-=2;
                ch2+=2;
                lettCount+=2;
            }
            else{
                h1+=2;
                h2-=2;
                ch1+=2;
                ch2-=2;
                lettCount-=2;
            }
            System.out.println();
        }
        sc.close();
    }
}