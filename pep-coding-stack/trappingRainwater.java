import java.util.*;
public class trappingRainwater {
    // We need to use this to calculate the value of the amount of rainwater that we are going to trap

    public static int trap(int[] heights){
        int n = heights.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        int max = -1;
        for(int i = 0; i < n; i++){
            if(heights[i] > max){
                max = heights[i];
            }
            prefixMax[i] = max;
        }
        max = -1;
        for(int i = n-1; i >= 0; i--){
            if(heights[i] > max){
                max = heights[i];
            }
            suffixMax[i] = max;
        }

        int totalArea = 0;
        for(int i = 0; i < n; i++){
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];
            if(heights[i] < leftMax && heights[i] < rightMax){
                totalArea += Math.min(leftMax,rightMax) - heights[i];
            }
        }
        return totalArea;
    }

    private static int trapBetter(int[] heights){
        int n = heights.length;
        int[] suffixMax = new int[n];
        suffixMax[n-1] = heights[n-1];
        for(int i = n-2; i >= 0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], heights[i]);
        }

        int rightMax = heights[0];
        int totalArea = 0;
        for(int i = 1; i < n; i++){
            if(heights[i] > rightMax) rightMax = heights[i];
            else{
                int leftMax = suffixMax[i];
                if(heights[i] < leftMax && heights[i] < rightMax){
                    totalArea += Math.min(leftMax,rightMax) - heights[i];
                }
            }
        }
        return totalArea;
    }

    private static int trapOpt(int[] heights){
        int n = heights.length;
        int lMax = 0, rMax = 0, totalArea = 0;
        int l = 0, r = n-1;

        while(l < r){
            if(heights[l] <= heights[r]){
                if(lMax > heights[l]){
                    totalArea += lMax - heights[l];
                }
                else{
                    lMax = heights[l];
                }
                l++;
            }
            else{
                if(rMax > heights[r]){
                    totalArea += rMax - heights[r];
                }
                else{
                    rMax = heights[r];
                }
                r--;
            }
        }
        return totalArea;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] layout = new int[n];
        for(int i=0;i<n;i++){
            layout[i] = sc.nextInt();
        }
        int count = trapOpt(layout);
        System.out.println(count);
        sc.close();
    }
}
