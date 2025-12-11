import java.util.*;

public class dailyTemperatures {
    public static int[] nextGreaterTemp(int[] temps){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temps.length];
        for(int i=temps.length-1;i>=0;i--){
            int temp = temps[i];
            while(!stack.isEmpty() && temps[stack.peek()] <= temp){
                stack.pop();
            }
            // The difference for the days will be the diff between current index and the index of the next greater element
            if(!stack.isEmpty()) ans[i] = stack.peek() - i;
            else ans[i] = 0;
            // Push the index and not the value itself
            stack.push(i);
        }
        // Empty the stack after use
        while(!stack.isEmpty()) stack.pop();
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] temps = new int[n];
        for(int i=0;i<n;i++){
            temps[i] = sc.nextInt();
        }
        int[] ans = nextGreaterTemp(temps);
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        sc.close();
    }    
}
