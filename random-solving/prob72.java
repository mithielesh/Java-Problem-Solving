import java.util.*;
public class prob72 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List <List<Integer>> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(sc.nextInt());
            }
            list.add(row);
        }
        sc.close();
    }
}
