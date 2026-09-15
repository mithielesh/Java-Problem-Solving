import java.util.*;
public class gridSearchProb {
    public static boolean gridSearch(List<String> grid, List<String> pattern){
        int n = grid.size();
        int s = pattern.size();
        int index = 0;
        int place = -1;
        int count = 0;
        for(int i=0;i<n;i++){
            String str = grid.get(i);
            if(str.indexOf(pattern.get(index)) != -1){
                int cur = str.indexOf(pattern.get(index));
                if(cur == place || place == -1){
                    index++;
                    place = cur;
                    count++;
                    if(count == s){
                        return true;
                    }
                    continue;
                }
            }
            count = 0;
            index = 0;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> grid = new ArrayList<>();
        for(int i=0;i<n;i++){
            String temp = sc.nextLine();
            grid.add(temp);
        }
        int s = sc.nextInt();
        List<String> pattern = new ArrayList<>();
        for(int i=0;i<s;i++){
            String temp = sc.nextLine();
            pattern.add(temp);
        }
        if(gridSearch(grid,pattern)) System.out.print("Present");
        else System.out.println("Not present");
        sc.close();
    }
}
