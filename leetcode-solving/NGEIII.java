public class NGEIII {
    public int nextGreaterElement(int n) {

        // Premature check
        if(n >= 1 && n <= 10) {
            return -1;
        }

        // 2147483647
        int temp = n, len = 0;
        while(temp != 0) {
            len++;
            temp /= 10;
        }
        int[] arr = new int[len];
        while(n != 0) {
            len--;
            arr[len] = n % 10;
            n /= 10;
        }

        int m = arr.length;
        boolean found = false;
        for(int j = m-2; j >= 0; j--) {
            if(arr[j] < arr[j+1]) {
                int l = j+1, r = m-1;
                while(l <= r) {
                    int ptr = arr[r];
                    arr[r] = arr[l];
                    arr[l] = ptr;
                    l++; r--;
                }
                int minInd = search(arr,j+1,m-1,arr[j]);
                int holder = arr[j];
                arr[j] = arr[minInd];
                arr[minInd] = holder;
                found = true;
                break;
            }
        }
        if(!found) {
            return -1;
        }

        len = (m == 10) ? 9 : m;

        int num = 0;
        for(int i = 0; i < len; i++) {
            num = (num * 10) + arr[i];
        }

        if(num > 214748364) {
            return -1;
        }
        else if(num == 214748364) {
            if(arr[9] >= 8) {
                return -1;
            }
            return (num * 10) + arr[9];
        }
        else if(m == 10) {
            return (num * 10) + arr[9];
        }
        
        return num;
    }
    private int search(int[] nums, int l, int r, int val) {
        int ind = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > val) {
                ind = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return ind;
    }
}