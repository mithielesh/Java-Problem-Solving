import java.util.Scanner;
public class prob21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max=0, secMax=0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int count=0;
        for(int j=0;j<n;j++){
            if(arr[j]!=max){
                if(arr[j]>secMax){
                    secMax = arr[j];
                }
            }
            else{
                count++;
            }
        }
        if(count>0){
            secMax = max;
        }
        System.out.println("Max element is: "+max);
        System.out.println("Second max element is: "+secMax);
        sc.close();
    }
}
