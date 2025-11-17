import java.util.*;
public class ratInAMazeIV {
    // The rat can move in all directions including diagonals we need to return all the possible paths
    public static void mazeMovement(int[][] maze){
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        move(maze,visited,ans,s,0,0,n);
        if(ans.size() == 0){
            System.out.println("There are no ways to complete the maze");
            return;
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static void move(int[][] maze, boolean[][] visited, List<String> ans, StringBuilder s, int i, int j, int n){
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0){
            return;
        }
        else if(i == n-1 && j == n-1){
            ans.add(s.toString());
            return;
        }
        visited[i][j] = true;
        // Checking in all the eight directions
        // Naming the dirtections D for down, U for up, L for left, R for right 
        // Also naming the diagonals S for up-left, O for up-right, X for down-left, Z for down-right
        // All are arranged in lexicographic order

        // Down
        if(i < n-1){
            if(!visited[i+1][j]){
                s.append('D');
                move(maze,visited,ans,s,i+1,j,n);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Left
        if(j > 0){
            if(!visited[i][j-1]){
                s.append('L');
                move(maze,visited,ans,s,i,j-1,n);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Up - Right
        if(i > 0 && j < n-1){
            if(!visited[i-1][j+1]){
                s.append('O');
                move(maze,visited,ans,s,i-1,j+1,n);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Right
        if(j < n-1){
            if(!visited[i][j+1]){
                s.append('R');
                move(maze,visited,ans,s,i,j+1,n);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Up = Left
        if(i > 0 && j > 0){
            if(!visited[i-1][j-1]){
                s.append('S');
                move(maze,visited,ans,s,i-1,j-1,n);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Up
        if(i > 0){
            if(!visited[i-1][j]){
                s.append('U');
                move(maze,visited,ans,s,i-1,j,n);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Down - Left
        if(i < n-1 && j > 0){
            if(!visited[i+1][j-1]){
                s.append('X');
                move(maze,visited,ans,s,i+1,j-1,n);
                s.deleteCharAt(s.length()-1);
            }
        }
        // Down - Right
        if(i < n-1 && j < n-1){
            if(!visited[i+1][j+1]){
                s.append('Z');
                move(maze,visited,ans,s,i+1,j+1,n);
                s.deleteCharAt(s.length()-1);
            }
        }

        // Backtracking now
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
