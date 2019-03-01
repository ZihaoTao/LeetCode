import java.util.ArrayList;
import java.util.List;

//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
//find all unique combinations in candidates where the candidate numbers sums to target.
//
//The same repeated number may be chosen from candidates unlimited number of times.
//
//Note:
//
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//Example 1:
//
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
//Example 2:
//
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]

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
