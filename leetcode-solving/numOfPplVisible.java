public class numOfPplVisible {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length, tos = 0;
        int[] stack = new int[n+1], ans = new int[n];
        stack[0] = -1;
        for(int i = n-1; i >= 0; i--) {
            int height = heights[i], count = 0;
            while(stack[tos] != -1 && stack[tos] < height) {
                count++;
                tos--;
            }
            if(stack[tos] == -1) {
                ans[i] = count;
            }
            else {
                ans[i] = count + 1;
            }
            tos++;
            stack[tos] = height;
        }
        return ans;
    }
}