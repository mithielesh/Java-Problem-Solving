import java.util.*;
public class prob83 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ch1 = 0, ch2 = n-1;
        for(int row = 0; row < n ; row++){
            if(row == 0){
                for(int i = 0; i < n;i ++){
                    System.out.print("C ");
                }
                System.out.println();
            }
            else if(row == n-1){
                for(int i = 0; i < n; i++){
                    System.out.print("K ");
                }
            }
            else{
                int size = (n-2) / 2;
                for(int i = 0; i < n; i++){
                    if(row <= size){
                        if(i == ch1 || i == ch2){
                            System.out.print("S ");
                        }
                        else{
                            System.out.print("* ");
                        }
                    }
                    else{
                        if(i == ch1 || i == ch2){
                            System.out.print("K ");
                        }
                        else{
                            System.out.print("* ");
                        }
                    }
                }
                System.out.println();
            }
            ch1++;
            ch2--;
        }
        sc.close();
    }
}
