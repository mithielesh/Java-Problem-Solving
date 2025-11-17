import java.util.*;
// This is the variation where we are going to make the start point variable
public class ratInAMazeIII {
    public static void mazeMovement(int[][] maze, int x, int y){
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        move(maze,visited,ans,s,n,x,y);
        if(ans.size() == 0){
            System.out.println("There is no way to reach the end."); 
            return;
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static void move(int[][] maze, boolean[][] visited, List<String> ans, StringBuilder s, int n, int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0){
            return;
        }
        else if(i == n-1 && j == n-1){
            ans.add(s.toString());
            return;
        }
        visited[i][j] = true;
        if(i < n-1){
            if(!visited[i+1][j]){
                s.append('D');
                move(maze,visited,ans,s,n,i+1,j);
                s.deleteCharAt(s.length()-1);
            }
        }
        if(j > 0){
            if(!visited[i][j-1]){
                s.append('L');
                move(maze,visited,ans,s,n,i,j-1);
                s.deleteCharAt(s.length()-1);
            }
        }
        if(j < n-1){
            if(!visited[i][j+1]){
                s.append('R');
                move(maze,visited,ans,s,n,i,j+1);
                s.deleteCharAt(s.length()-1);
            }
        }
        if(i > 0){
            if(!visited[i-1][j]){
                s.append('U');
                move(maze,visited,ans,s,n,i-1,j);
                s.deleteCharAt(s.length()-1);
            }
        }
        visited[i][j] = false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the maze: ");
        int n = sc.nextInt();
        System.out.print("Enter the start coordinates of the rat: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("Enter the elements in the maze:");
        int[][] maze = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        mazeMovement(maze,x,y);
        sc.close();
    } 
}