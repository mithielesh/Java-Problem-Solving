import java.util.*;
public class rottenOranges {
    private static int timeToRot(int[][] basket) {
        int n = basket.length;
        int m = basket[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(basket[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        int time = -1;
        while(!q.isEmpty()) {
            int level = q.size();
            time++;
            for(int i = 0; i < level; i++) {
                int[] coord = q.poll();
                changer(basket,coord,q);
            }
        }
        // Final check
        for(int[] row : basket) {
            for(int fruit : row) {
                if(fruit == 1) {
                    return -1;
                }
            }
        }
        return (time >= 0) ? time : 0;
    }
    private static void changer(int[][] basket, int[] coord, Queue<int[]> q) {
        int i = coord[0];
        int j = coord[1];
        if(i-1 >= 0) {
            if(basket[i-1][j] == 1) {
                basket[i-1][j] = 2;
                q.offer(new int[]{i-1,j});
            }
        }
        if(i+1 < basket.length) {
            if(basket[i+1][j] == 1) {
                basket[i+1][j] = 2;
                q.offer(new int[]{i+1,j});
            }
        }
        if(j-1 >= 0) {
            if(basket[i][j-1] == 1) {
                basket[i][j-1] = 2;
                q.offer(new int[]{i,j-1});
            }
        }
        if(j+1 < basket[0].length) {
            if(basket[i][j+1] == 1) {
                basket[i][j+1] = 2;
                q.offer(new int[]{i,j+1});
            }
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] basket = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                basket[i][j] = sc.nextInt();
            }
        }
        int time = timeToRot(basket);
        if(time == -1) {
            System.out.println("All the oranges are not rotten");
        }
        else {
            System.out.println("The time taken to rot all oranges is: "+time);
        }
        sc.close();
    }
}
