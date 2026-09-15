import java.util.Scanner;
public class checkSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = sc.nextLine();
        int result = calculateCheckSum(userInput.getBytes());
        System.out.println("Checksum: "+result);
        sc.close();
    }
    public static int calculateCheckSum(byte[] data){
            int sum=0;
            for(int i=0;i<data.length;i++){
                sum += data[i];
            }
            return sum;
    }
}
