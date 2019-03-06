import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, "" + root.val);
        return res;
    }

    private void dfs(TreeNode node, String s) {
        if(node.left == null && node.right == null) {
            res.add(s);
        } else {
            if(node.left != null) {
                String t = s;
                s += "->" + node.left.val;
                dfs(node.left, s);
                s = t;
            }
            if(node.right != null) {
                String t = s;
                s += "->" + node.right.val;
                dfs(node.right, s);
                s = t;
            }
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
