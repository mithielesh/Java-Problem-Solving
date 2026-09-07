import java.util.LinkedList;
import java.util.Queue;

public class triangularSumOfArray {

    public int triangularSum(int[] nums) {
        // The sum of the triangle is just like the sequence of a pascals triangle
        // [a] = a, [a,b] = a + b, [a,b,c] = a + 2b + c, [a,b,c,d] = a + 3b + 3c + d, [a,b,c,d,e] = a + 4b + 6c + 4d + e

        // Constant Integer overflows
        int len = nums.length;
        int sum = nums[0], r = 0, n = len-1, fact = 1;
        for(int i = 1; i < len; i++) {
            fact *= (n - r);
            fact /= (r + 1);
            sum += nums[i] * fact;
            r++;
        }
        return sum % 10;
    }

    public int triangularSumII(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for(int num : nums) {
            q.offer(num);
        }
        while(q.size() > 1) {
            int len = q.size();
            for(int i = 0; i < len-1; i++) {
                int val = q.poll() + q.peek();
                q.offer(val % 10);
            }
            // Remove the last element
            q.poll();
        }
        return q.poll();
    }

    public int triangularSumIII(int[] nums) {
        int n = nums.length;
        for(int j = n; j > 1; j--) {
            for(int i = 1; i < j; i++) {
                nums[i-1] = (nums[i] + nums[i-1]) % 10;
            }
        }
        return nums[0];
    }
}