import java.util.*;
public class landMineProb {
    public static void landmine(char[][] field, int n){
        int count = 0;
        boolean[][] visited = new boolean[n][n];
        explore(visited,n,0,0, field);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]){
                    count++;
                }
            }
        }
        System.out.println("The number of visited cells are: "+count);
    }
    public static void explore(boolean[][] visited, int n, int i, int j,char[][] field){
        visited[i][j] = true;
        if(canMove(field,visited,n,i,j+1,"EAST",i,j)){
            if(!visited[i][j+1]){
                explore(visited,n,i,j+1,field);
            }
        }
        if(canMove(field,visited,n,i,j-1,"WEST",i,j)){
            if(!visited[i][j-1]){
                explore(visited,n,i,j-1,field);
            }
        }
        if(canMove(field,visited,n,i-1,j,"NORTH",i,j)){
            if(!visited[i-1][j]){
                explore(visited,n,i-1,j,field);
            }
        }
        if(canMove(field,visited,n,i+1,j,"SOUTH",i,j)){
            if(!visited[i+1][j]){
                explore(visited,n,i+1,j,field);
            }
        }
    }
    public static boolean canMove(char[][] field, boolean[][] visited, int n, int i, int j, String dir,int si, int sj){
        if(i < 0 || i >= n || j < 0 || j >= n){
            return false;
        }
        if(field[i][j] == 'M'){
            return false;
        }
        boolean beeps = scanner(field,n,si,sj,dir);
        if(beeps && !visited[i][j]){
            return false;
        }
        return true;
    }
    public static boolean scanner(char[][] field,int n,int i,int j,String direction){
        if(direction.equals("EAST")){
            for(int k=j;k<n;k++){
                if(field[i][k] == 'M') return true;
            }
        }
        else if(direction.equals("WEST")){
            for(int k=j;k>=0;k--){
                if(field[i][k] == 'M') return true;
            }
        }
        else if(direction.equals("NORTH")){
            for(int k=i;k>=0;k--){
                if(field[k][j] == 'M') return true;
            }
        }
        else if(direction.equals("SOUTH")){
            for(int k=i;k<n;k++){
                if(field[k][j] == 'M') return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] field = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                field[i][j] = sc.next().charAt(0);
            }
        }
        landmine(field,n);
        sc.close();
    }
}
