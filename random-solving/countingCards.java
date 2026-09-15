import java.util.*;
public class countingCards {
    public static void countCards(int[] arr, int n){
        int aPoint = 0, bPoint = 0;
        for(int i=0;i<n;i++){
            char player = (i%2 == 0) ? 'A' : 'B';
            int card = arr[i];
            if(card == 1 && (n-i-1) >= 4){
                if(!isHighCard(arr[i+1]) && !isHighCard(arr[i+2]) && !isHighCard(arr[i+3]) && !isHighCard(arr[i+4])){
                    System.out.printf("Player %c scores 4 point(s)\n",player);
                    if(player == 'A') aPoint+=4;
                    else bPoint+=4;
                }
            }
            else if(card == 13 && (n-i-1) >= 3){
                if(!isHighCard(arr[i+1]) && !isHighCard(arr[i+2]) && !isHighCard(arr[i+3])){
                    System.out.printf("Player %c scores 3 point(s)\n",player);
                    if(player == 'A') aPoint+=3;
                    else bPoint+=3;
                }
            }
            else if(card == 12 && (n-i-1) >= 2){
                if(!isHighCard(arr[i+1]) && !isHighCard(arr[i+2])){
                    System.out.printf("Player %c scores 2 point(s)\n",player);
                    if(player == 'A') aPoint+=2;
                    else bPoint+=2;
                }
            }
            else if(card == 11 && (n-i-1) >= 1){
                if(!isHighCard(arr[i+1])){
                    System.out.printf("Player %c scores 1 point(s)\n",player);
                    if(player == 'A') aPoint++;
                    else bPoint++;
                }
            }
        }
        System.out.printf("Player A: %d point(s)\n",aPoint);
        System.out.printf("Player B: %d point(s)\n",bPoint);
    }
    public static boolean isHighCard(int card){
        if(card == 1 || card == 13 || card == 12 || card == 11){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of cards: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        countCards(arr,n);
        sc.close();
    }
}
