import java.util.Scanner;
public class prob36 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of children");
        int n = sc.nextInt();
        String[] gender = new String[n];
        int[] startDate = new int[n];
        int[] endDate = new int[n];
        for(int i=0;i<n;i++){
            gender[i] = sc.next();
            startDate[i] = sc.nextInt();
            endDate[i] = sc.nextInt();
            sc.nextLine();
        }
        int maxKids=0;
        for(int i=1;i<367;i++){
            int boysCount=0;
            int girlsCount=0;
            for(int j=0;j<n;j++){
                if(i>=startDate[j]&&i<=endDate[j]){
                    if(gender[j].equals("M")||gender[j].equals("B")){
                        boysCount++;
                    }
                    else{
                        girlsCount++;
                    }
                }
            }
            int pairs = Math.min(girlsCount, boysCount);
            int countToday = pairs*2;
            if(countToday>maxKids){
                maxKids = countToday;
            }
        }
        System.out.println("The maximum number of children that can attend on the same day is "+maxKids);
        sc.close();
    }
}
