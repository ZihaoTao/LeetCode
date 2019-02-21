import java.util.*;

public class permute {
    List<List<Integer>> res;
    Set<Integer> set;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        set = new HashSet<>();
        dfs(nums, list);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {

            for(int i = 0; i < nums.length; i++) {
                if(!set.contains(nums[i])) {
                    set.add(nums[i]);
                    list.add(nums[i]);
                    dfs(nums, list);
                    list.remove(list.size() - 1);
                    set.remove(nums[i]);
                }
            }
        }
    }
}
