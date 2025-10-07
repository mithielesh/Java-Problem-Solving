import java.util.Scanner;
public class prob40 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();
        int qx = sc.nextInt();
        int qy = sc.nextInt();
        String[][] queenBoard = new String[n][n];
        String[][] bishopBoard = new String[n][n];
        String[][] finalBoard = new String[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                queenBoard[i][j] = "-";
                bishopBoard[i][j] = "-";
            }
        }
        // Queen board
        queenBoard[qx-1][qy-1] = "Q";
        for(int i=0;i<n;i++){
            if(queenBoard[i][qy-1].equals("Q")){
                continue;
            }
            queenBoard[i][qy-1] = "$";
        }
        for(int j=0;j<n;j++){
            if(queenBoard[qx-1][j].equals("Q")){
                continue;
            }
            queenBoard[qx-1][j] = "$";
        }
        if(qx-1!=0&&qy-1==n-1){
            //for(int i=)
        }
        sc.close();
    }
}
