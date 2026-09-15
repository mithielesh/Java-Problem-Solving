import java.util.Scanner;
public class prob17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double score = 0;
        int n;
        int PCOUNT = 0;
        do{
            n = sc.nextInt();
            if(n%2==0 && n>0){
                score -= 0.5;
            }
            else if(n<0){
                score -= 1;;
            }
            else{
                if(PCOUNT<3){
                    PCOUNT++;
                    score += 1;
                }
                }
            }while(n>0 && PCOUNT<3);
        System.out.printf("%.1f",score);
        sc.close();
    }
}