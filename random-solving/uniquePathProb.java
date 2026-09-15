import java.util.*;
public class uniquePathProb {
    public static int uniquePath(List<List<Integer>> grid, int r, int c){
        int startX=0, startY=0;
        int todoPath = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid.get(i).get(j) == 0){
                    todoPath++;
                }
                if(grid.get(i).get(j) == 1){
                    startX = i;
                    startY = j;
                }
            }
        }
        int paths = explore(grid,r,c,startX,startY,todoPath);
        return paths;
    }
    public static int explore(List<List<Integer>> grid, int r, int c, int i, int j, int todoPath){
        if(i < 0 || i >= r || j < 0 || j >= c || grid.get(i).get(j) == -1) return 0;

        if(grid.get(i).get(j) == 2){
            if(todoPath == 0){
                return 1;
            }
            return 0;
        }

        int originalVal = grid.get(i).get(j);
        if(originalVal == 0) todoPath--;
        grid.get(i).set(j,-1);
        int pathsFound = 0;
        
        pathsFound += explore(grid,r,c,i-1,j,todoPath);
        pathsFound += explore(grid,r,c,i+1,j,todoPath);
        pathsFound += explore(grid,r,c,i,j-1,todoPath);
        pathsFound += explore(grid,r,c,i,j+1,todoPath);

        grid.get(i).set(j,originalVal);
        return pathsFound;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt();
        List<List<Integer>> grid = new ArrayList<>();
        System.out.println("Enter the elements in the array: ");
        for(int i=0;i<r;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<c;j++){
                row.add(sc.nextInt());
            }
            grid.add(row);
        }
        int paths = uniquePath(grid,r,c);
        System.out.println("The number of unique paths are "+paths);
        sc.close();
    }
}
