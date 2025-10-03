import java.util.Scanner;
public class prob31 {
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     String[][] field = new String[n][n];
    //     int[] row = new int[n];
    //     int[] col = new int[n];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             field[i][j] = sc.next();
    //         }
    //     }
    //     int mineCount=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             if(field[i][j].equals("M")){
    //                 mineCount++;
    //             }
    //         }
    //         if(mineCount==0){
    //             row[i] = 1;
    //         }
    //         else{
    //             row[i] = -1;
    //         }
    //         mineCount = 0;
    //     }
    //     for(int j=0;j<n;j++){
    //         for(int i=0;i<n;i++){
    //             if(field[i][j].equals("M")){
    //                 mineCount++;
    //             }
    //         }
    //         if(mineCount==0){
    //             col[j] = 1;
    //         }
    //         else{
    //             col[j] = -1;
    //         }
    //         mineCount = 0;
    //     }
    //     int sum=0;
    //     int rowCount=0, colCount=0;
    //     for(int i=0;i<n;i++){
    //         if(row[i]==1){
    //             sum += n;
    //             rowCount++;
    //         }
    //         if(col[i]==1){
    //             sum += n;
    //             colCount++;
    //         }
    //     }
    //     int overlap = colCount*rowCount;
    //     System.out.println(sum-overlap);
    //     sc.close();
    // }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] field = new String[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                field[i][j] = sc.nextLine();
            }
        }
        // Row wise checking
        for(int i=0;i<n;i++){
            boolean flag = false;
            for(int j=0;j<n;j++){
                if(field[i][j].equals("M")){
                    flag = true;
                }
            }
            if(!flag){
                for(int j=0;j<n;j++){
                    field[i][j] = "S";
                }
            }
        }
        // Column wise checking
        for(int j=0;j<n;j++){
            boolean flag = false;
            for(int i=0;i<n;i++){
                if(field[i][j].equals("M")){
                    flag = true;
                }
            }
            if(!flag){
                for(int i=0;i<n;i++){
                    field[i][j] = "S";
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(field[i][j].equals("S")){
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
