import java.util.*;
public class ratInAMaze {
    public static void mazeMovement(int[][] maze){
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        StringBuilder s = new StringBuilder();
        List<String> ans = new ArrayList<>();
        move(maze,visited,0,0,n,s,ans);
        if(ans.size() == 0){
            System.out.println("The rat cannot complete the maze");
        }
        else{
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
        }
    }
    public static void move(int[][] maze, boolean[][] visited, int i, int j, int n, StringBuilder s, List<String> ans){
        // Checking for the out of bounds or for the case where the maze is blocked
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0){
            return;
        }
        else if(i == n-1 && j == n-1){
            ans.add(s.toString());
        }
        visited[i][j] = true;
        // Do the movement checks lexicographically
        // First we do the check the downward direction
        if(i < n-1){
            if(!visited[i+1][j]){
                s.append('D');
                move(maze,visited,i+1,j,n,s,ans);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Check in the left direction
        if(j > 0){
            if(!visited[i][j-1]){
                s.append('L');
                move(maze,visited,i,j-1,n,s,ans);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Check in the right direction
        if(j < n-1){
            if(!visited[i][j+1]){
                s.append('R');
                move(maze,visited,i,j+1,n,s,ans);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Check in the upward direction
        if(i > 0){
            if(!visited[i-1][j]){
                s.append('U');
                move(maze,visited,i-1,j,n,s,ans);
                s.deleteCharAt(s.length()-1);
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
