import java.util.*;

public class carCollisions {
    public static int countCollisions(String directions){
        int count = 0;
        int n = directions.length();
        int l = 0, r = n - 1;

        //First find the boundary limits
        // the left boundary first
        int lCount = 0;
        while(l < n && directions.charAt(l) == 'L'){
            l++;
            lCount++;
        }
        // then the right boundary
        int rCount = 0;
        while(r >= 0 && directions.charAt(r) == 'R'){
            r--;
            rCount++;
        }
        if(rCount + lCount == directions.length()) return 0;

        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String directions = sc.next();
        int count = countCollisions(directions);
        System.out.println(count);
        sc.close();
    }    
}
