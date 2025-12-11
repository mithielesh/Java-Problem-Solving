import java.util.*;

public class slidingWindow {
    public static int[] maxValArrSW(int[] arr, int k){
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        // Store the indices of the next greater elements
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) nge[i] = stack.peek();
            else nge[i] = n;
            stack.push(i);
        }
        // Empty the stack
        while(!stack.isEmpty()) stack.pop();
        // Kepp doing the checks until the next greater element is not found in the window size.
        //  Because otherwise the answer is the greatest number in the window size
        int[] maxArr = new int[n-k+1];
        int winMaxInd = k-1;
        int j = 0;
        for(int i=0;i<=n-k;i++){
            // Only bring back j if i crosses the limits. This makes it O(n)
            if (j < i) {
                j = i;
            }
            // Keep checking until within window size
            while(nge[j] <= winMaxInd){
                j = nge[j];
            }
            maxArr[i] = arr[j];
            winMaxInd++;
        }
        return maxArr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] maxArr = maxValArrSW(arr,k);
        for(int i=0;i<maxArr.length;i++){
            System.out.print(maxArr[i]+" ");
        }
        sc.close();
    }    
}
