public class asteroidCollision {
    public int[] collision(int[] nums) {
        int n = nums.length, tos = 0;
        int[] stack = new int[n+1];
        stack[0] = -1001; 
        for(int i = 0; i < n; i++) {
            boolean canAdd = true;
            while(stack[tos] != -1001) {
                if(stack[tos] > 0 && nums[i] > 0) {
                    break;
                }
                else if(stack[tos] < 0 && nums[i] < 0) {
                    break;
                }
                else if(stack[tos] > 0 && nums[i] < 0) {
                    int size = 0 - nums[i];
                    if(size < stack[tos]) {
                        canAdd = false;
                        break;
                    }
                    if(size == stack[tos]) {
                        canAdd = false;
                        tos--;
                        break;
                    }
                    tos--;
                }
                else {
                    break;
                }
            }
            if(canAdd) {
                tos++;
                stack[tos] = nums[i];
            }
        }
        int[] ans = new int[tos];
        for(int i = 1; i <= tos; i++) {
            ans[i-1] = stack[i];
        }
        return ans;
    }
}