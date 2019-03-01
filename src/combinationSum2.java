import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Given a collection of candidate numbers (candidates) and a target number (target),
//find all unique combinations in candidates where the candidate numbers sums to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note:
//
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//Example 1:
//
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//Example 2:
//
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
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
