import java.util.*;
public class findingPath {
    public static boolean findPath(List<List<Integer>> matrix, int n, int m, int sx, int sy, int ex, int ey){
        if(sx < 0 || sx >= n || sy < 0 || sy >= m || matrix.get(sx).get(sy) == 0 || matrix.get(sx).get(sy) == -1){
            return false;
        }
        if(sx == ex && sy == ey){
            return true;
        }
        // Change the value to avoid the infinite condition
        matrix.get(sx).set(sy, -1);
        if(findPath(matrix,n,m,sx-1,sy,ex,ey)) return true;
        if(findPath(matrix,n,m,sx+1,sy,ex,ey)) return true;
        if(findPath(matrix,n,m,sx,sy-1,ex,ey)) return true;
        if(findPath(matrix,n,m,sx,sy+1,ex,ey)) return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = sc.nextInt();
        System.out.println("Enter the elements in the array: ");
        List<List<Integer>> matrix = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<m;j++){
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }
        System.out.println("Enter the start coordinates: ");
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        System.out.println("Enter the end coordinates: ");
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        boolean ans = findPath(matrix, n,m,sx,sy,ex,ey);
        if(ans) System.out.println("There is a path");
        else System.out.println("There is no path");
        sc.close();
    }
}
