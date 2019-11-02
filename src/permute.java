import java.util.*;

public class permute {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, list);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(!list.contains(nums[i])) {
                    list.add(nums[i]);
                    dfs(nums, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
