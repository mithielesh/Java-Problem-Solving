import java.util.*;
public class superRatInAMazeIII {
    public static void mazeMovement(int[][] maze){
        int r = maze.length;
        int c = maze[0].length;
        int ki = 0, kj = 0;
        boolean flag = false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                // Cosidering that 0 is the obstacles 1 is the path and 9 is the key
                if(maze[i][j] == 9){
                    ki = i;
                    kj = j;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        boolean[][][] visited = new boolean[r][c][2]; 
        boolean hasKey = false;
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        mover(ans,maze,visited,s,r,c,0,0,ki,kj,hasKey,0,false);
        if(ans.size() == 0){
            System.out.println("There is no way to complete.");
            return;
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static void mover(List<String> ans, int[][] maze, boolean[][][] visited, StringBuilder s, int r, int c,
    int i ,int j, int ki, int kj, boolean hasKey, int check, boolean addedKey){
        if(i < 0 || i >= r || j < 0 || j >=c || maze[i][j] == 0){
            return;
        }
        if(i == ki && j == kj){
            if (!hasKey) { // Only add K if we didn't have it already
                s.append('K');
                hasKey = true;
                check = 1;
                addedKey = true; // Remember that we added it
            }   
        }
        if(i == r-1 && j == c-1 && hasKey){
            ans.add(s.toString());
            return;
        }
        visited[i][j][check] = true;
        // Check down
        if(i < r-1 && !visited[i+1][j][check]){
            s.append('D');
            mover(ans,maze,visited,s,r,c,i+1,j,ki,kj,hasKey,check,false);
            s.deleteCharAt(s.length()-1);
        }
        // Check left
        if(j > 0 && !visited[i][j-1][check]){
            s.append('L');
            mover(ans,maze,visited,s,r,c,i,j-1,ki,kj,hasKey,check,false);
            s.deleteCharAt(s.length()-1);
        }
        // Check right
        if(j < c-1 && !visited[i][j+1][check]){
            s.append('R');
            mover(ans,maze,visited,s,r,c,i,j+1,ki,kj,hasKey,check,false);
            s.deleteCharAt(s.length()-1);
        }
        // Check up
        if(i > 0 && !visited[i-1][j][check]){
            s.append('U');
            mover(ans,maze,visited,s,r,c,i-1,j,ki,kj,hasKey,check,false);
            s.deleteCharAt(s.length()-1);
        }
        // Backtrack
        visited[i][j][check] = false;
        if(addedKey){
            s.deleteCharAt(s.length()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] maze = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        mazeMovement(maze);
        sc.close();
    }
}
