import java.util.*;

public class numberOfPathMaxScore {
    static int MOD = 1000000007;
    private static int[] pathsWithMaxScore(List<String> board) {
        Integer[][][] memo = new Integer[board.size()][board.get(0).length()][];
        int[] result = helper(0,0,board,memo);
        return (result[0] < 0) ? new int[]{0,0} : result;
    }
    private static int[] helper(int i, int j, List<String> board, Integer[][][] memo) {
        if(i < 0 || i >= board.size() || j < 0 || j >= board.get(0).length() || board.get(i).charAt(j) == 'X') {
            return new int[]{-1,0};
        }
        if(board.get(i).charAt(j) == 'S') {
            return new int[]{0,1};
        }
        if(memo[i][j] != null) {
            return new int[]{memo[i][j][0], memo[i][j][1]};
        }

        int[] right = helper(i,j+1,board,memo);
        int[] down = helper(i+1,j,board,memo);
        int[] diag = helper(i+1,j+1,board,memo);

        int maxScore = Math.max(right[0], Math.max(down[0], diag[0]));
        if(maxScore == -1) {
            memo[i][j] = new Integer[]{-1,0};
            return new int[]{-1,0};
        }
        int totalPaths = 0;

        if(right[0] == maxScore) totalPaths = (totalPaths + right[1]) % MOD;
        if(down[0] == maxScore) totalPaths = (totalPaths + down[1]) % MOD;
        if(diag[0] == maxScore) totalPaths = (totalPaths + diag[1]) % MOD;

        int finalScore = maxScore;
        if(board.get(i).charAt(j) != 'E') {
            finalScore = ((board.get(i).charAt(j) - '0') + maxScore) % MOD;
        }
        memo[i][j] = new Integer[]{finalScore,totalPaths};
        return new int[]{finalScore, totalPaths};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(sc.hasNext()) {
            list.add(sc.next());
        }
        int[] result = pathsWithMaxScore(list);
        System.out.println(result[0] + " " + result[1]);
        sc.close();
    }
}