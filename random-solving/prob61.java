import java.util.Scanner;
public class prob61 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String temp = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                continue;
            }
            temp += str.charAt(i);
        }
        double val = Math.sqrt(temp.length());
        int row = (int)Math.round(val);
        int col=0;
        if(val>row){
            col = row+1;
        }
        else{
            col = row;
        }
        System.out.println(row+" "+col);
        int n=0;
        char[][] ans = new char[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(n==str.length()){
                    ans[i][j] = ' ';
                    continue;
                }
                ans[i][j] = str.charAt(n);
                n++;
            }
        }
        String res="";
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                //System.out.print(ans[j][i]);
                if(ans[j][i]!=' '){
                    res += ans[j][i];
                }
            }
            //System.out.print(" ");
            res += " ";
        }
        System.out.println(res.trim());
    }
}
