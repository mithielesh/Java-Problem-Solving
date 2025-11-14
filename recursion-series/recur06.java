import java.util.*;
public class recur06 {
    public static void printPerm(int[] arr, List<Integer> list, List<List<Integer>> ans, boolean[] visited){
        // we are not using the optimal apprach here this is using up O(n) space
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        // Loop through the array every single time to find the elements not visited
        for(int i=0; i<arr.length; i++){
            // Default array set to completely false so it is initially true for all cases
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                printPerm(arr,list,ans,visited);
                // Remove the element every time during the back track
                list.removeLast();
                // Also set the visited status to false as it is now free to visit again
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        printPerm(arr,list,ans,visited);
        System.out.println("The different permutations of the array are: ");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}
