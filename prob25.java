import java.util.Scanner;
public class prob25{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String tent = sc.nextLine();
        int n= tent.length(), count=0;
        for(int i=0;i<n;i++){
            if(i==0){
                if(tent.charAt(i)=='1'&&n>1){
                    if(tent.charAt(i+1)=='1'){
                        count=0;
                        continue;
                    }
                    else{
                        count+=2;
                    }
                }
                else if(tent.charAt(i)=='1'&&n==1){
                    count = 1;
                    break;
                }
                else if(tent.charAt(i)=='0'&&n==1){
                    count = 0;
                    break;
                }
            }
            else if(i==n-1){
                if(tent.charAt(i)=='1'){
                    count+=2;
                }
            }
            else if(tent.charAt(i)=='1'){
                if(tent.charAt(i+1)!='1'){
                    count+=3;
                }
                else{
                    count+=1;
                }
            }
            else{
                continue;
            }
        }
        int left = n-count;
        if(left<0){
            left=0;
        }
        System.out.println(left);
        sc.close();
    }
}