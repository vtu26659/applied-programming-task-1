import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // build path
        if (path.isEmpty()) {
            path = "" + node.val;
        } else {
            path = path + "->" + node.val;
        }

        // if leaf node
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // go deeper
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}