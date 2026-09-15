import java.util.*;
public class flippingBorderProb {
    public static void flippingBorder(List<List<Character>> matrix, int n){
        // looping along the borders 
        // the first row
        for(int i=0;i<n;i++){
            // first row
            if(matrix.get(0).get(i) == 'O'){
                explore(matrix,n,0,i);
            }
            // last row
            if(matrix.get(n-1).get(i) == 'O'){
                explore(matrix,n,n-1,i);
            }
            // first column
            if(matrix.get(i).get(0) == 'O'){
                explore(matrix,n,i,0);
            }
            // last column
            if(matrix.get(i).get(n-1) == 'O'){
                explore(matrix,n,i,n-1);
            }
        }
        // Setting up the safe ones and changing the unsafe ones
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix.get(i).get(j)=='S'){
                    matrix.get(i).set(j,'O');
                }
                else if(matrix.get(i).get(j)=='O'){
                    matrix.get(i).set(j,'X');
                }
            }
        }
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void explore(List<List<Character>> matrix, int n, int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= n || matrix.get(i).get(j) != 'O'){
            return;
        }

        matrix.get(i).set(j, 'S');
        explore(matrix,n,i-1,j);
        explore(matrix,n,i+1,j);
        explore(matrix,n,i,j-1);
        explore(matrix,n,i,j+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements in the array: ");
        List<List<Character>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.next().charAt(0));
            }
            matrix.add(row);
        }
        sc.close();
        flippingBorder(matrix,n);
    }
}
