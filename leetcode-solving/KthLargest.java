public class KthLargest {
    PriorityQueue<Integer> q;
    int size, kVal;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        size = q.size(); kVal = k;
        for(int num : nums) {
            if(size < k) {
                size++;
                q.offer(num);
            } 
            else if(num >= q.peek()) {
                q.poll();
                q.offer(num);
            }
        }
    }
    
    public int add(int val) {
        if(size < kVal) {
            size++;
            q.offer(val);
        }
        else if(val >= q.peek()) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */