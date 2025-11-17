import java.util.*;
// Learning to write cleaner smaller code using loops and direction arrays
public class ratInAMazeV {

    private static int[] row = {1,0,0,-1};
    private static int[] col = {0,-1,1,0};
    private static char[] dir = {'D','L','R','U'};

    public static void mazeMovement(int[][] maze){
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        move(maze, visited, ans, s, 0, 0, n);
        if(ans.size() == 0){
            System.out.println("There are no paths.");
            return;
        }
        for(int k=0;k<ans.size();k++){
            System.out.print(ans.get(k)+" ");
        }
    }
    public static void move(int[][] maze, boolean[][] visited, List<String> ans, StringBuilder s, int i, int j, int n){
        if(i == n-1 && j == n-1){
            ans.add(s.toString());
            return;
        }
        visited[i][j] = true;
        // Doing the checks using loops checking in the direction arrays
        for(int k=0;k<4;k++){
            int x = i + row[k];
            int y = j + col[k];
            char c = dir[k];
            // Checking for the constraints and the boundary checks
            if(x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && !visited[x][y]){
                s.append(c);
                move(maze,visited,ans,s,x,y,n);
                s.deleteCharAt(s.length() - 1);
            }
        }
         visited[i][j] = false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        mazeMovement(maze);
        sc.close();
    }
}
