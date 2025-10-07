import java.util.Scanner;
public class prob43 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elemnts in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        // Calculating the combinations of the non decreasing sub arrays that can be formed
        int streak=0, count=0;
        for(int i=0;i<n;i++){
            if(i==0){
                streak++;
            }
            else if(i>0){
                if(arr[i]>=arr[i-1]){
                    streak++;
                }
                else{
                    streak = 0;
                    streak++;
                }
            }
            count += streak;
        }
        System.out.println("The total possible ubarrays of non decreasing numbers are:"+count);
        sc.close();
    }
}
