import java.util.*;
public class landminePrac {
    //the pathfinder that counts the number of steps
    public static int pathFinder(char[][] field, int n){
        // create a visited array to mark the position as visited
        boolean[][] visited = new boolean[n][n];
        explore(visited,field,n,0,0);
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    // the explore function explores in the four directions
    public static void explore(boolean[][] visited, char[][] field, int n, int i, int j){
        // mark the currene position as visited
        visited[i][j] = true;

        // Make the move only if it is already visited or safe
        // in the right side that is EAST
        if(canMove(visited,field,n,i,j+1,"EAST",i,j)){
            if(!visited[i][j+1]){
                explore(visited,field,n,i,j+1);
            }
        }
        // in the left direction that is WEST
        if(canMove(visited,field,n,i,j-1,"WEST",i,j)){
            if(!visited[i][j-1]){
                explore(visited,field,n,i,j-1);
            }
        }
        // in the top direction that is NORTH
        if(canMove(visited,field,n,i-1,j,"NORTH",i,j)){
            if(!visited[i-1][j]){
                explore(visited,field,n,i-1,j);
            }
        }
        // in the bottom direction that is SOUTH
        if(canMove(visited,field,n,i+1,j,"SOUTH",i,j)){
            if(!visited[i+1][j]){
                explore(visited,field,n,i+1,j);
            }
        }
    }
    // this function checks if we can make the move
    public static boolean canMove(boolean[][] visited, char[][] field, int n, int ni, int nj, String dir, int si, int sj){
        // this checks if we off the field
        if(ni < 0 || ni >= n || nj < 0 || nj >= n){
            return false;
        }
        // check if we are on a landmine
        if(field[ni][nj] == 'M'){
            return false;
        }

        // check if there is any landmine in the direction
        boolean beeps = mineScanner(field,n,si,sj,dir);

        // if we have not visted and there is a mine in that direction then we dont need to go in that direction
        if(beeps && !visited[ni][nj]){
            return false;
        }
        return true;
    }
    //this check if there are mines in the direction
    public static boolean mineScanner(char[][] field,int n, int i, int j, String dir){
        if(dir.equals("EAST")){
            for(int k=j;k<n;k++){
                if(field[i][k] == 'M') return true;
            }
        }
        if(dir.equals("WEST")){
            for(int k=j;k>=0;k--){
                if(field[i][k] == 'M') return true;
            }
        }
        if(dir.equals("NORTH")){
            for(int k=i;k>=0;k--){
                if(field[k][j] == 'M') return true;
            }
        }
        if(dir.equals("SOUTH")){
            for(int k=j;k<n;k++){
                if(field[k][j] == 'M') return true;
            }
        }
        return false;
    }
    //writing the main function for getting input and displaying the output
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the field: ");
        int n = sc.nextInt();
        char[][] field = new char[n][n];
        System.out.println("Enter the elements in the field: ");
        for(int i=0;i<n;i++){
            String row = sc.next();
            field[i] = row.toCharArray();
        }
        int steps = pathFinder(field,n);
        System.out.println("The total spaces that the soldier can move through is "+steps+" steps");
        sc.close();
    }
}
