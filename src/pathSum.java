import java.util.ArrayList;
import java.util.List;

public class pathSum {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> list = new ArrayList<>();
        dfs(root, sum, list);
        return res;
    }

    private void dfs (TreeNode root, int sum, List<Integer> list) {
        if(root != null) {
            list.add(root.val);
            if(root.left == null && root.right == null && sum == root.val){
                res.add(new ArrayList<>(list));
            }
            dfs(root.left, sum - root.val, list);
            dfs(root.right, sum - root.val, list);
            list.remove(list.size() - 1);
        }
    }
}
