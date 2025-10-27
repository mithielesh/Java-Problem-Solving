import java.util.*;
public class flippingMatrix {
    public static void flipLayer(List<List<Integer>> matrix, int row, int col, int key){
        int n = (Math.min(row,col)) / 2;

        // Setting the up the constant variables
        int index1 = 0, index2 = col-1, index3 = row-1, index4 = 0;
        // Setting up the increasing and the decreasing vars for the loops
        int ind1 = 0, ind2=1, ind3 = col-1, ind4 = row-2;
        int ind5 = col, ind6 = row-1, ind7 = 0, ind8 = 0;

        // rotation of the layers, identifying and peeling
        for(int i=0;i<n;i++){
            
            int index = 0;
            List <Integer> rotate = new ArrayList<>();

            // trversing and adding the the first row
            for(int j=ind1;j<ind5;j++){
                // we consider the row val to be 0 here
                rotate.add(matrix.get(index1).get(j));
            }

            // traversing and adding the last column
            for(int j=ind2;j<ind6;j++){
                // we consider the col val to be col-1 here
                rotate.add(matrix.get(j).get(index2));
            }

            // traversing and adding the last row
            for(int j=ind3;j>=ind7;j--){
                // we consider the row val to be row-1 here
                rotate.add(matrix.get(index3).get(j));
            }

            //traversing and adding the first column
            for(int j=ind4;j>ind8;j--){
                // we consider the col val to be 0
                rotate.add(matrix.get(j).get(index4));
            }
            int k = key % rotate.size();
            Collections.rotate(rotate,-k);

            //Setting the elements back in place
            for(int j=ind1;j<ind5;j++){
                // we consider the row val to be 0 here
                matrix.get(index1).set(j, rotate.get(index));
                index++;
            }

            for(int j=ind2;j<ind6;j++){
                // we consider the col val to be col-1 here
                matrix.get(j).set(index2, rotate.get(index));
                index++;
            }

            for(int j=ind3;j>=ind7;j--){
                // we consider the row val to be row-1 here
                matrix.get(index3).set(j, rotate.get(index));
                index++;
            }

            for(int j=ind4;j>ind8;j--){
                // we consider the col val to be 0
                matrix.get(j).set(index4, rotate.get(index));
                index++;
            }
            
            // This is for the reducing row and col
            index1++;
            index2--;
            index3--;
            index4++;
            // Reducing the layer size
            ind1++;
            ind5--;
            ind2++;
            ind6--;
            ind3--;
            ind7++;
            ind4--;
            ind8++;
        }
        System.out.println("\nThe multi layer rotated array is: ");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrix.get(i).get(j)+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        List <List<Integer>> matrix = new ArrayList<>();
        for(int i=0;i<row;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<col;j++){
                list.add(sc.nextInt());
            }
            matrix.add(list);
        }
        int k = sc.nextInt();
        flipLayer(matrix, row, col, k);
        sc.close();
    }
}
