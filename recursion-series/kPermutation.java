import java.util.*;
public class kPermutation {
    static int count = 0;
    public static String permutation(int n, int k){
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        boolean[] visited = new boolean[n];
        StringBuilder s = new StringBuilder();
        permute(n,k,s,0,arr,visited);
        return s.toString();
    }   
    public static boolean permute(int n, int k, StringBuilder s, int index, int[] arr, boolean[] visited){
        if(index == n){
            count++;
            if(count == k){
                return true;
            }
            return false;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                s.append(arr[i]);
                if(permute(n,k,s,index+1,arr,visited)){
                    return true;
                }else{
                    visited[i] = false;
                    s.deleteCharAt(s.length()-1);
                }
            }
        }
        return false;
    }

    // public static void swap(int[] arr, int i, int j){
    //     int temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;
    // }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String ans = permutation(n,k);
        System.out.print(ans);
        sc.close();
    }
}
