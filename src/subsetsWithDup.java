import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDup {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, list);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
