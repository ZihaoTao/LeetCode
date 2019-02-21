import java.util.*;

public class permuteUnique {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        dfs(nums, list, set);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, Set<Integer> set) {
        if(list.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(i != 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                if(!set.contains(i)) {
                    list.add(nums[i]);
                    set.add(i);
                    dfs(nums, list, set);
                    set.remove(i);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
