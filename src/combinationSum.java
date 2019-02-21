import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, list);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> list) {
        if(target == 0) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
        } else {
            for(int i = index; i < candidates.length; i++) {
                if(candidates[i] <= target) {
                    list.add(candidates[i]);
                    dfs(candidates, target - candidates[i], i, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
