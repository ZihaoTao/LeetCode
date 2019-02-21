import java.util.ArrayList;
import java.util.List;

public class jump {
    List<Integer> list;
    public int jump(int[] nums) {
        list = new ArrayList<>();
        dfs(nums, 0, 0);
        int res = Integer.MAX_VALUE;
        for(int i : list) {
            res = Math.min(res, i);
        }
        return res;
    }

    private void dfs(int[] nums, int index, int count) {
        if(index == nums.length - 1) {
            list.add(count);
        } else {
            for(int i = 1; i <= nums[index]; i++) {
                if(index + i < nums.length) {
                    count++;
                    dfs(nums, index + i, count);
                    count--;
                }
            }
        }
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        int inf = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            dp[i] = inf;
        }
        for(int i = 0; i < n; i++) {
            int j = Math.min(i + nums[i], n - 1);
            for(; j >= i; j--) {
                if(dp[j] < inf)
                    break;
                dp[j] = Math.min(dp[i] + 1,dp[j]);
            }
        }
        return dp[n - 1];
    }

    public int jump3(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= i + nums[i]; j++) {
                if(j < nums.length) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                } else {
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] test = {2,3,1,1,4};
        System.out.println((new jump()).jump3(test));
    }
}
