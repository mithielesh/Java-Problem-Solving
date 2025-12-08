import java.util.*;

public class NGER_II {
    public static void nextGreatestElement(int[] arr){
        int n = arr.length;
        int ind = findMaxIndex(arr);
        Stack<Integer> stack = new Stack<>();
        for(int i=ind+n;i>ind;i--){
            int num = arr[i % n];
            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            if(!stack.isEmpty()) arr[i % n] = stack.peek();
            else arr[i % n] = -1;
            stack.push(num);
        }
        // Empty the stack
        while(!stack.isEmpty()) stack.pop();
    }
    public static int findMaxIndex(int[] arr){
        int max = Integer.MIN_VALUE;
        int maxInd = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
                maxInd = i;
            }
        }
        return maxInd;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        nextGreatestElement(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
