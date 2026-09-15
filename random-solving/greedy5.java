import java.util.*;
public class greedy5 {
    // public static int minJumps(List<Integer> arr, int n){
        // int max = 0;
        // int indexReached = 0;
        // int jumps=0;
        // for(int i=0;i<n;i++){
        //     if(arr.get(i) > max){
        //         max = arr.get(i);
        //         indexReached = i+max;
        //         jumps++;
        //     }
        //     if(indexReached >= n-1){
        //         break;
        //     }
        // }
        // return jumps;
    // }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Integer> jumps = new ArrayList<>();
        for(int i=0;i<n;i++){
            jumps.add(sc.nextInt());
        }
        sc.close();
        // int minJumps = minJumps(jumps,n);
        // System.out.println(minJumps);
    }
}
