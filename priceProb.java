import java.util.*;
public class priceProb {
    public static int combinationCounter(int pP, int pG, int pR, int pO, int cost){
        int p=0,g=0,r=0,o=0;
        if(cost != 0){
            p= cost/pP;
            g= cost/pG;
            r= cost/pR;
            o=cost/pO;
        }
        int min = Integer.MAX_VALUE;
        int combi=0;
        for(int i=0;i<=p;i++){
            for(int j=0;j<=g;j++){
                for(int k=0;k<=r;k++){
                    for(int l=0;l<=o;l++){
                        int val = (pP * i) + (pG * j) + (pR * k) + (pO * l);
                        if(val == cost){
                            System.out.printf("# of PINK is %d # of GREEN is %d # of RED is %d # of ORANGE is %d\n",i,j,k,l);
                            combi++;
                            int count = i + j + k + l;
                            if(count < min){
                                min = count;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The total number of combinations is "+combi);
        return min;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int pP = sc.nextInt();
        int pG = sc.nextInt();
        int pR = sc.nextInt();
        int pO = sc.nextInt();
        int cost = sc.nextInt();
        int min = combinationCounter(pP,pG,pR,pO,cost);
        System.out.println("Minimum number of tickets to print is "+min);
        sc.close();
    }
}
