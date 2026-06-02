import java.util.*;

public class battleship {
    private static int countBattleships(char[][] board) {
        int n = board.length, m = board[0].length;
        int battleShip = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'X') {
                    if(i != 0) {
                        if(board[i-1][j] == 'X') {
                            continue;
                        }
                    }
                    if(j != 0) {
                        if(board[i][j-1] == 'X') {
                            continue;
                        }
                    }
                    battleShip++;
                }
            }
        }
        return battleShip;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] board = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(countBattleships(board));
        sc.close();
    }
}