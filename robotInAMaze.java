import java.util.*;
// In this the robot can be facing in any direction and only moves forward. 
// But due to the R and L commands changes the way it faces

public class robotInAMaze {
    // Setup direction arrays
    // This is the mst important because we are shifting the direction accessing index by adding 1 and % 4 for right and 
    // adding 3 and % 4 for left so it remains integral to set it up that way
    // The order being   N  E   S   W
    private static int[] row = {-1,0,1,0};
    private static int[] col = {0,1,0,-1};
    
    public static void robotMover(int r, int c, char[][] field, int x, int y, int q, char[] commands){
        List<List<Integer>> ans = new ArrayList<>();
        // The robot can be facing in any of the four direction so the code gets executed in a different way for each 
        mover(ans,field,r,c,commands,x,y);
        Collections.sort(ans, (a,b) ->{
            if(a.get(0) != b.get(0)){
                return a.get(0) - b.get(0);
            }else{
                return a.get(1) - b.get(1);
            }
        });
        for(int i=0; i<ans.size(); i++){
            for(int j=0; j<ans.get(0).size(); j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
        
    }
    public static void mover(List<List<Integer>> ans, char[][] field, int r, int c, char[] commands, int a, int b){
        for(int i=0;i<4;i++){
            int check = i;
            boolean flag = true;
            int x = a;
            int y = b;
            for(int j=0;j<commands.length;j++){
                if(commands[j] == 'F'){
                    x += row[check];
                    y += col[check];
                }
                else if(commands[j] == 'R'){
                    check = (check + 1) % 4;
                }
                else if(commands[j] == 'L'){
                    check = (check + 3) % 4;
                }
                if(x < 0 || x >= r || y < 0 || y >= c || field[x][y] == 'X'){
                    flag = false;
                    break;
                }
            } 
            if(flag){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                ans.add(list);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt();
        sc.nextLine();
        char[][] field = new char[r][c];
        System.out.println("Enter the contents of the field:");
        for(int i=0;i<r;i++){
            String row = sc.next();
            field[i] = row.toCharArray();
        }
        System.out.print("Enter the x coordinate of the robot: ");
        int x = sc.nextInt();
        System.out.print("Enter the y coordinate of the robot: ");
        int y = sc.nextInt();
        System.out.println("Enter the number of queries/commands: ");
        int q = sc.nextInt();
        sc.nextLine();
        char[] commands = new char[q];
        System.out.print("Enter the commands:");
        for(int i=0;i<q;i++){
            commands[i] = sc.next().charAt(0);
        }
        robotMover(r,c,field,x,y,q,commands);
        sc.close();
    }
}
