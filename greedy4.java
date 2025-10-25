import java.util.*;
public class greedy4 {
    public static boolean reached(List<Integer> arr, int n){
        int maxIndex = 0;
        int index=0;
        for(int i=0;i<n;i++){
            if(i<=maxIndex){
                index = i + arr.get(i);
                // Update only if you know you are going further
                if(index > maxIndex){
                    maxIndex = index;
                }
            }else{
                // You have not and will never reach here
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Integer> jumps = new ArrayList<>();
        for(int i=0;i<n;i++){
            jumps.add(sc.nextInt());
        }
        sc.close();
        boolean result = reached(jumps, n);
        if(result){
            System.out.println("Reached");
        }else{
            System.out.println("Couldn't reach");
        }
    }
}
