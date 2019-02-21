import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates.length == 0) return res;
        Arrays.sort(candidates);
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
                if(i != index && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                if(target >= candidates[i]) {
                    list.add(candidates[i]);
                    dfs(candidates, target - candidates[i], i + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }


}
