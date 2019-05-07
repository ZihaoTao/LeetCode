import java.util.*;

public class permuteUnique {
    List<List<Integer>> res;
    Set<Integer> set;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        set = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(nums, list);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(i != 0 && nums[i - 1] == nums[i] && !set.contains(i - 1)) continue;
                if(!set.contains(i)) {
                    set.add(i);
                    list.add(nums[i]);
                    dfs(nums, list);
                    list.remove(list.size() - 1);
                    set.remove(i);
                }
            }
        }
    }
}
