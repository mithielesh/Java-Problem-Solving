import java.util.*;
public class countIslandsProb {
    public static int countingIslands(List<List<Integer>> matrix, int n, int m){
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count += explore(matrix,i,j,n,m);
            }
        }
        return count;
    }
    public static int explore(List<List<Integer>> matrix, int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || matrix.get(i).get(j) == 0){
            return 0;
        }
        matrix.get(i).set(j, 0);
        explore(matrix,i-1,j,n,m);
        explore(matrix,i+1,j,n,m);
        explore(matrix,i,j-1,n,m);
        explore(matrix,i,j+1,n,m);
        // explore(matrix,i-1,j-1,n,m);
        // explore(matrix,i-1,j+1,n,m);
        // explore(matrix,i+1,j-1,n,m);
        // explore(matrix,i+1,j+1,n,m);

        return 1;
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
        int count = countingIslands(matrix,n,m);
        System.out.println("The number of islands are: "+count);
        sc.close();
    }
}
