import java.util.*;
public class snakeInAMatrix {
    public static int finalPositionOfSnake(int n, List<String> commands) {
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = (i*n) + j;
            }
        }
        int ans = 0;
        int r=0,c=0;
        for(int i=0;i<commands.size();i++){
            String command = commands.get(i);
            if(command.equals("RIGHT")){
                c++;
                ans = board[r][c];
            }
            else if(command.equals("LEFT")){
                c--;
                ans = board[r][c];
            }
            else if(command.equals("UP")){
                r--;
                ans = board[r][c];
            }
            else{
                r++;
                ans = board[r][c];
            }
        }
        return ans;
    }
    public static int finalPositionOfSnakeII(int n, List<String> commands){
        int x = 0, y = 0;
        for(String dir : commands){
            if(dir.equals("UP")){
                x--;
            }
            if(dir.equals("DOWN")){
                x++;
            }
            if(dir.equals("LEFT")){
                y--;
            }
            if(dir.equals("RIGHT")){
                y++;
            }
        }
        int loc = (x*n)+y;
        return loc;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> commands = new ArrayList<>();
        while(sc.hasNext()){
            commands.add(sc.next());
        }
        int ans = finalPositionOfSnake(n,commands);
        System.out.println("The final position of the snake is: "+ans);
        int loc = finalPositionOfSnakeII(n,commands);
        System.out.println("The final position of the snake is: "+loc);
        sc.close();
    }
}
