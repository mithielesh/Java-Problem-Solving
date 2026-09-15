import java.util.*;
public class gridSearchProb2 {
    public static boolean gridSearch(List<String> grid, List<String> pattern){
        int n = grid.size();
        int s = pattern.size();
        // All the pattern strings will have the same size
        int l = pattern.get(0).length();
        for(int i=0;i<=n-s;i++){
            String temp = grid.get(i);
            // Assuming that every string will have a different length
            int w = temp.length();
            for(int j=0;j<=w-l;j++){
                String substr = temp.substring(j,j+l);
                if(substr.equals(pattern.get(0))){
                    boolean flag = true;
                    for(int k=1;k<s;k++){
                        String temp2 = grid.get(i+k);
                        String sub = temp2.substring(j,j+l);
                        if(!sub.equals(pattern.get(k))){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) return true;
                }
            }
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
        sc.nextLine();
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
