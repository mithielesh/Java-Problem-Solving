import java.util.*;
public class Bomber {
    public static List<String> bomberMan(List<String> grid, int rows, int n){
        int sec = n%4;
        int val = grid.get(0).length();
        List <String> zeros = new ArrayList<>();
        for(int i=0;i<grid.size();i++){
            String temp = "";
            for(int j=0;j<val;j++){
                temp += "O";
            }
            zeros.add(temp);
        }
        if(sec==1){
            return grid;
        }else if(sec==0 || sec==2){
            return zeros;
        }
            List <StringBuilder> list = new ArrayList<>();
            for(int i=0;i<rows;i++){
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<val;j++){
                    temp.append("O");
                }
                list.add(temp);
            }
            for(int i=0;i<rows;i++){
                for(int j=0;j<val;j++){
                    if(grid.get(i).charAt(j)=='O'){
                        list.get(i).setCharAt(j,'.');
                        if(i>0){
                            list.get(i-1).setCharAt(j,'.');
                        }
                        if(i<rows-1){
                            list.get(i+1).setCharAt(j,'.');
                        }
                        if(j>0){
                            list.get(i).setCharAt(j-1,'.');
                        }
                        if(j<val-1){
                            list.get(i).setCharAt(j+1,'.');
                        }
                    }
                }
            }
            List <String> ans = new ArrayList<>();
                for(StringBuilder sb : list){
                    ans.add(sb.toString());
                }
            return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the number of seconds: ");
        int time = sc.nextInt();
        sc.nextLine();
        List <String> grid = new ArrayList<>();
        System.out.println("Enter the rows: ");
        for(int i=0;i<row;i++){
            String temp = sc.nextLine();
            grid.add(temp);
        }
        List <String> result = bomberMan(grid, row, time);
        System.out.println("\nThe answer is: \n");
        for(int i=0;i<row;i++){
            System.out.println(result.get(i));
        }
        sc.close();
    }
}
