import java.util.*;

public class sortArrByParityII {
    private static void paritySort(int[] arr) {
        int ptr1 = 0, ptr2 = 1, n = arr.length;
        while(ptr1 < n && ptr2 < n) {
            while(ptr1 < n && arr[ptr1] % 2 == 0) {
                ptr1 += 2;
            }
            while(ptr2 < n && arr[ptr2] % 2 == 1) {
                ptr2 += 2;
            }
            if(ptr1 < n) {
                int temp = arr[ptr1];
                arr[ptr1] = arr[ptr2];
                arr[ptr2] = temp;
            }
        }
        return arr;

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        paritySort(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}