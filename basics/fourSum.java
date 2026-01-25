import java.util.*;
public class fourSum {
    public static List<List<Integer>> fourSumCombinations(int[] arr, int target){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        if(n <= 3) return ans;
        for(int i = 0; i < n - 3; i++){     
            if(i > 0 && arr[i] == arr[i-1]) continue; 
            for(int ptr = i + 1; ptr <= n - 3; ptr++){
                if(ptr > i + 1 && arr[ptr] == arr[ptr - 1]) continue;
                long requiredSum = arr[i] + arr[ptr];
                int ptr2 = ptr + 1, ptr3 = n - 1;
                while(ptr2 < ptr3){
                    long sum = arr[ptr2] + arr[ptr3];
                    if(requiredSum + sum == (long)target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[ptr]);
                        temp.add(arr[ptr2]);
                        temp.add(arr[ptr3]);
                        ans.add(temp);
                        ptr2++;
                        ptr3--;

                        while(ptr2 < ptr3 && arr[ptr2] == arr[ptr - 1]){
                            ptr2++;
                        }
                        while(ptr2 < ptr3 && arr[ptr3] == arr[ptr3 + 1]){
                            ptr3--;
                        }
                    }
                    else if(sum + requiredSum < (long)target){
                        ptr2++;
                    }
                    else{
                        ptr3--;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<List<Integer>> ans = fourSumCombinations(arr, target);
        System.out.println(ans);
        sc.close();
    }
}
