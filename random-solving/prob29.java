import java.util.Scanner;
public class prob29 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] gender = new String[n];
        int[] startDate = new int[n];
        int[] endDate = new int[n];
        // Getting the inputs
        for(int i=0;i<n;i++){
            gender[i] = sc.next();
            startDate[i] = sc.nextInt();
            endDate[i] = sc.nextInt();
        }
        // Checking the boys and girls available
        int maxKids=0;
        for(int days=1;days<367;days++){
            int boysToday = 0;
            int girlsToday = 0;
            for(int i=0;i<n;i++){
                if(days>=startDate[i]&&days<=endDate[i]){
                    if(gender[i].equals("B")||gender[i].equals("M")){
                        boysToday++;
                    }
                    else{
                        girlsToday++;
                    }
                }
            }
            // Taking the minimun value as we need both boy and girl and then multiply by 2 make pair
            int pairs = Math.min(girlsToday,boysToday);
            int kidsToday = pairs*2;
            // Used to find the ,aximum number of kids that can come on that day
            if(kidsToday>maxKids){
                maxKids = kidsToday;
            }
        }
        System.out.println(maxKids);
        sc.close();
    }
}
