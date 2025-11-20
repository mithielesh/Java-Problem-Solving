import java.util.*;
public class superRatInAMazeI {
    // The jumps mentioned over here, it means that the rat can at max jump that may squares, but it can still do the smaller jumps
    public static void mazeMovement(int[][] maze){
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        mover(maze,visited,ans,s,n,0,0);
        if(ans.size() == 0){
            System.out.println("No way for the rat to complete the maze");
        }
        else{
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
        }
        
    }
    public static void mover(int[][] maze, boolean[][] visited, List<String> ans, StringBuilder s, int n, int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0){
            return;
        }
        else if(i == n-1 && j == n-1){
            ans.add(s.toString());
            return;
        }
        visited[i][j] = true;
        // Check in all the four directions
        int jump = maze[i][j];
        // Check in the downward direction
        if(i < n - jump){
            for(int k=1;k<=jump;k++){
                if(!visited[i+k][j]){
                    s.append('D');
                    mover(maze,visited,ans,s,n,i+k,j);
                    s.deleteCharAt(s.length() - 1);
                }
            }
        }
        //Check in the left direction
        if(j >= jump){
            for(int k=1;k<=jump;k++){
                if(!visited[i][j-k]){
                    s.append('L');
                    mover(maze,visited,ans,s,n,i,j-k);
                    s.deleteCharAt(s.length() - 1);
                }
            }
        }
        // Check in the right direction
        if(j < n - jump){
            for(int k=1;k<=jump;k++){
                if(!visited[i][j+jump]){
                    s.append('R');
                    mover(maze,visited,ans,s,n,i,j+k);
                    s.deleteCharAt(s.length() - 1);
                }
            }
        }
        // Check in the upward direction
        if(i >= jump){
            for(int k=1;k<=jump;k++){
                if(!visited[i-jump][j]){
                    s.append('U');
                    mover(maze,visited,ans,s,n,i-k,j);
                    s.deleteCharAt(s.length() - 1);
                }
            }
        }
        // Doing the backtracking
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
