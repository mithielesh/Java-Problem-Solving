import java.util.Scanner;
public class prob31 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] field = new String[n][n];
        int[] row = new int[n];
        int[] col = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                field[i][j] = sc.next();
            }
        }
        int mineCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(field[i][j].equals("M")){
                    mineCount++;
                }
            }
            if(mineCount==0){
                row[i] = 1;
            }
            else{
                row[i] = -1;
            }
            mineCount = 0;
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                if(field[i][j].equals("M")){
                    mineCount++;
                }
            }
            if(mineCount==0){
                col[j] = 1;
            }
            else{
                col[j] = -1;
            }
            mineCount = 0;
        }
        int sum=0, overlap=0, rowCount=0, colCount=0; 
        if(row[0]==-1&&col[0]==-1){
            System.out.println("1");
            sc.close();
            return;
        }
        else{
            if(row[0]!=-1){
                if(col[0]!=-1){
                    sum += 0;
                }
                else{
                    sum += n;
                    rowCount++;
                }
                for(int i=0;i<n;i++){
                    if(col[i]==1){
                        sum += n;
                        colCount++;
                    }
                }
            }
            if(col[0]!=-1){
                if(row[0]!=-1){
                    sum += 0;
                }
                else{
                    sum += n;
                    colCount++;
                }
                for(int i=0;i<n;i++){
                    if(row[i]==1){
                        sum += n;
                        rowCount++;
                    }
                }
            }
            if(colCount>0&&rowCount==0){
                for(int i=1;i<n;i++){
                    if(row[i]==1){
                        sum+=n;
                        rowCount++;
                    }
                }
            }
            else if(rowCount>0&&colCount==0){
                for(int i=1;i<n;i++){
                    if(col[i]==1){
                        sum+=n;
                        colCount++;
                    }
                }
            }
        }
        
        if(rowCount>0&&colCount>0){
            overlap = rowCount*colCount;
            sum = sum - overlap;
            System.out.println(sum);
        }
        else{
            System.out.println(sum);
        }
        sc.close();
    }
    
}
