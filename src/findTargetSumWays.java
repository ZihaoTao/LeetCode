public class findTargetSumWays {

    int res;
    public int findTargetSumWays(int[] nums, int S) {
        res = 0;
        if(nums.length == 0) return res;
        dfs(nums, 0, S);
        return res;
    }

    private void dfs(int[] nums, int index, int S) {
        if(index == nums.length && S == 0) {
            res++;
        } else if (index < nums.length) {
            dfs(nums, index + 1, S + nums[index]);
            dfs(nums, index + 1, S - nums[index]);
        }
    }
}
