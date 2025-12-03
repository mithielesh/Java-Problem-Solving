import java.util.*;

public class stockSpan {
    public static void spanner(int[] stocks){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<stocks.length;i++){
            int stock = stocks[i];
            if(i == 0){
                // The first element will always be the initial element
                stack.push(stock);
                stocks[i] = 1;
            }
            else{
                int span = 1;
                while(!stack.isEmpty() && stack.peek() < stock){
                    stack.pop();
                    span++;
                }
                // If the stack is empty then it means that the span is the total distance from the start
                if(stack.isEmpty()){
                    stocks[i] = i+1;
                }
                // Else we are going to use the span from the element
                else{
                    stocks[i] = span;
                }
                stack.push(stock);
            }
        }
        // Empty the stack after using
        while(!stack.isEmpty()) stack.pop();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stocks = new int[n];
        for(int i=0;i<n;i++){
            stocks[i] = sc.nextInt();
        }
        spanner(stocks);
        System.out.println("The span of the stocks are:");
        for(int i=0;i<stocks.length;i++){
            System.out.print(stocks[i]+" ");
        }
        sc.close();
    }    
}
