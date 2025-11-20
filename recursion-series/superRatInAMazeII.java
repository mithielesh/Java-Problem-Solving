import java.util.*;
public class superRatInAMazeII {
    public static int mazeMovement(int[][] maze){
        int r = maze.length;
        int c = maze[0].length;
        preProcessing(maze,r,c);
        // The mines and its neighbours have all been marked as 1 for avoidance
        int min = Integer.MAX_VALUE;
        for(int i=0;i<r;i++){
            if(maze[i][0] == 0){
                int count = 0;
                boolean[][] visited = new boolean[r][c];
                List<Integer> list = new ArrayList<>();
                mover(list,maze,visited,count,r,c,i,0);
                // Checking for the smallest size
                for(int j : list){
                    if(j < min){
                        min = j;
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
    public static void preProcessing(int[][] maze, int r, int c){
        List<List<Integer>> marked = new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(maze[i][j] == 1){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    marked.add(list);
                }
            }
        }
        for(List<Integer> list : marked){
            int x = list.get(0);
            int y = list.get(1);
            if(x > 0){
                maze[x-1][y] = 1;
            }
            if(x < r-1){
                maze[x+1][y] = 1;
            }
            if(y > 0){
                maze[x][y-1] = 1;
            }
            if(y < c-1){
                maze[x][y+1] = 1;
            }
        }
    }
    public static void mover(List<Integer> list, int[][] maze, boolean[][] visited, int count, int r, int c, int i, int j){
        if(i < 0 || i >= r || j < 0 || j >= c || maze[i][j] == 1){
            return;
        }
        if(j == c-1){
            list.add(count);
            return;
        }
        // mark as visited
        visited[i][j] = true;
        if(i > 0 && !visited[i-1][j]){
            mover(list,maze,visited,count+1,r,c,i-1,j);
        }
        if(i < r-1 && !visited[i+1][j]){
            mover(list,maze,visited,count+1,r,c,i+1,j);
        }
        if(j > 0 && !visited[i][j-1]){
            mover(list,maze,visited,count+1,r,c,i,j-1);
        }
        if(j < c-1 && !visited[i][j+1]){
            mover(list,maze,visited,count+1,r,c,i,j+1);
        }
        // Backtrack
        visited[i][j] = false; 
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
        int minDist = mazeMovement(maze);
        if(minDist == -1) System.out.println("It cannot reach the last column");
        else System.out.println("It can reach the end in "+minDist+" steps");
        sc.close();
    }
}
