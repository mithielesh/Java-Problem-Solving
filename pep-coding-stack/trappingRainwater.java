import java.util.*;
public class trappingRainwater {
    // We need to use this to calculate the value of the amount of rainwater that we are going to trap

    public static int trap(int[] heights){
        int height = 0;
        int width = 0;
        int totVol = 0;
        return totVol;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] layout = new int[n];
        for(int i=0;i<n;i++){
            layout[i] = sc.nextInt();
        }
        int count = trap(layout);
        System.out.println(count);
        sc.close();
    }
}
