import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode node, String s) {
        if(node.left == null && node.right == null) {
            res.add(s + node.val);
        } else {
            if(node.left != null) dfs(node.left, s + node.val + "->");
            if(node.right != null)dfs(node.right, s + node.val + "->");
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println((new binaryTreePaths()).binaryTreePaths(root));
    }
}
