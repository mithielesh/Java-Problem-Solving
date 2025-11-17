import java.util.*;
public class ratInAMazeII {
    // Need to just return the count of the valid paths
    public static void mazeMovement(int[][] maze){
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        int count = move(maze,visited,n,0,0);
        System.out.println("There are "+count+" ways to reach the end point.");
    }
    public static int move(int[][] maze, boolean[][] visited, int n, int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0){
            return 0;
        }
        else if(i == n-1 && j == n-1){
            return 1;
        }
        int count = 0;
        visited[i][j] = true;
        if(i < n-1){
            if(!visited[i+1][j]){
                count += move(maze,visited,n,i+1,j);
            }
        }
        if(j > 0){
            if(!visited[i][j-1]){
                count += move(maze,visited,n,i,j-1);
            }
        }
        if(j < n-1){
            if(!visited[i][j+1]){
                count += move(maze,visited,n,i,j+1);
            }
        }
        if(i > 0){
            if(!visited[i-1][j]){
                count += move(maze,visited,n,i-1,j);
            }
        }
        // Backtracking or else it does not unmark the path once visited
        visited[i][j] = false;
        return count;
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