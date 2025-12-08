import java.util.*;
// Next greater element on the right
public class NGER {
    public static void nextGreaterElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length - 1; i >= 0; i--){
            int num = arr[i];
            if(i == arr.length - 1){
                arr[i] = -1;
            }
            else{
                while(!stack.isEmpty() && stack.peek() <= num){
                    stack.pop();
                }
                if(!stack.isEmpty()) arr[i] = stack.peek();
                else arr[i] = -1;
            }
            stack.push(num);
        }
        // Emptying the stack
        while(!stack.isEmpty()) stack.pop();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        nextGreaterElement(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }    
}
