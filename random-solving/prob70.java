import java.util.Scanner;
public class prob70 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the chess board: ");
        int n = sc.nextInt();
        System.out.println("Enter the position of the queen: ");
        System.out.print("X-coordinate: ");
        int qx = sc.nextInt();
        System.out.print("Y-coordinate: ");
        int qy = sc.nextInt();
        System.out.print("Do you want an obstacle?: ");
            System.out.println("Enter the position of the pawn: ");
            System.out.print("X-coordinate: ");
            int px = sc.nextInt();
            System.out.print("Y-coordinate: ");
            int py = sc.nextInt();
        
        sc.close();
        int top = qx-1;
        int bottom = n-qx;
        int left = qy-1;
        int right = n-qy;
        int topLeft = Math.min(left,top);
        int bottomLeft = Math.min(bottom,left);
        int topRight = Math.min(top,right);
        int bottomRight = Math.min(bottom,right);
        int pawnL = qy - py - 1;
        int pawnR = py - qy - 1;
        int pawnT = qx - px - 1;
        int pawnB = px - qx - 1;
        if(px==qx){
            if(py<qy){
                left = pawnL;
            }
            else{
                right = pawnR;
            }
        }
        else if(py==qy){
            if(px<qx){
                top = pawnT;
            }
            else{
                bottom = pawnB;
            }
        }
        else if((py<qy)&&(px<qx)){
            if(pawnL==pawnT){
                topLeft = pawnL;
            }
        }
        else if((py>qy)&&(px<qx)){
            if(pawnR==pawnT){
                topRight = pawnR;
            }
        }
        else if((py<qy)&&(px>qx)){
            if(pawnL==pawnB){
                bottomLeft = pawnL;
            }
        }
        else if((py>qy)&&(px>qx)){
            if(pawnR==pawnB){
                bottomRight = pawnR;
            }
        }
        int moves = top+left+right+bottom+topLeft+bottomLeft+topRight+bottomRight;
        System.out.println("The total number of moves is: "+moves);
    }
}
