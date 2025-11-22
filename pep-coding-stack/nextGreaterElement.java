import java.util.*;
public class nextGreaterElement {
    // Considering that our array contains only discrete elements
    public static void calculateNGE(int[] arr, int n){
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int num = arr[i];
            if(i == n-1){
                stack.push(num);
                arr[i] = -1;
            }
            else{
                while(!stack.isEmpty() && stack.peek() < num){
                    stack.pop();
                }
                if(stack.isEmpty()) arr[i] = -1;
                else arr[i] = stack.peek();
                stack.push(num);
            }
        }
        // Emptying the stack after use
        while(!stack.isEmpty()){
            stack.pop();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        calculateNGE(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
