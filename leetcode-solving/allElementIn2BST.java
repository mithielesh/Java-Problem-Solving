import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// import javax.swing.tree.TreeNode;

public class allElementIn2BST {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Brute force
        List<Integer> ans = new ArrayList<>();
        helper(root1,ans);
        helper(root2,ans);
        Collections.sort(ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        ans.add(root.val);
        helper(root.left,ans);
        helper(root.right),ans;
    }
    // Method 2 would be to take the 2 trees individually and use the merging algo to merge them. But that is intensive on memory
    /*
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Brute force
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(root1,arr1);
        helper(root2,arr2);
        int i = 0, j = 0, n = arr1.size(), m = arr2.size();
        while(i < n && j < m) {
            if(arr1.get(i) <= arr2.get(j)) {
                ans.add(arr1.get(i));
                i++;
            }
            else {
                ans.add(arr2.get(j));
                j++;
            }
        }
        while(i < n) {
            ans.add(arr1.get(i));
            i++;
        }
        while(j < m) {
            ans.add(arr2.get(j));
            j++;
        }
        return ans;
    }
    private void helper(TreeNode root, List<Integer> arr) {
        if(root == null) {
            return;
        }
        helper(root.left,arr);
        arr.add(root.val);
        helper(root.right,arr);
    }
     */

}