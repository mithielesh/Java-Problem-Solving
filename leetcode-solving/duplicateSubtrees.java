/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class duplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> duplicates = new ArrayList<>();
        dfs(root,map,duplicates);
        return duplicates;
    }
    private String dfs(TreeNode root, Map<String,Integer> map, List<TreeNode> duplicates) {
        if(root == null) {
            return "#";
        }
        String left = dfs(root.left,map,duplicates);
        String right = dfs(root.right,map,duplicates);
        StringBuilder sb = new StringBuilder();
        sb.append(left).append(right).append('#').append(root.val);
        String current = sb.toString();
        if(map.containsKey(current)) {
            if(map.get(current) == 0) {
                map.put(current,1);
                duplicates.add(root);
            }
        }
        else {
            map.put(current,0);
        }
        return current;
    } 
}