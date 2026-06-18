import java.util.*;

public class mergeTwoSortedArrays {
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return;
        }
        int ptr = m + n - 1;
        int ptr1 = m - 1, ptr2 = n - 1;
        while(ptr1 >= 0 && ptr2 >= 0) {
            if(nums2[ptr2] >= nums1[ptr1]) {
                // nums1[ptr] is guaranteed to be 0
                nums1[ptr] = nums2[ptr2];
                ptr2--;
            }
            else {
                nums1[ptr] = nums1[ptr1];
                ptr1--;
            }
            ptr--;
        }
        while(ptr2 >= 0) {
            nums1[ptr] = nums2[ptr2];
            ptr--;
            ptr2--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] brr = new int[n];
        for(int i = 0; i < n; i++) {
            brr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr = new int[m+n];
        for(int i = 0; i < m+n; i++) {
            arr[i] = sc.nextInt();
        }
        merge(arr,m,brr,n);
        for(int i = 0; i < m+n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}