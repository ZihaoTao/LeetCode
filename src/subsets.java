import java.util.ArrayList;
import java.util.List;

public class subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list) {
        res.add(new ArrayList<Integer>(list));
        for(int i = index; i < nums.length; i ++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
