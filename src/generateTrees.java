import java.util.ArrayList;
import java.util.List;

public class generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if(l > r) {
            res.add(null);
            return res;
        }
        for(int i = l; i <= r; i++) {
            List<TreeNode> ls = helper(l, i - 1);
            List<TreeNode> rs = helper(i + 1, r);
            for(TreeNode p : ls) {
                for(TreeNode q : rs) {
                    TreeNode node = new TreeNode(i);
                    node.left = p;
                    node.right = q;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        (new generateTrees()).generateTrees(3);
    }
}
