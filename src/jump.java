import java.util.ArrayList;
import java.util.List;

public class jump {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];

        for(int i = 1; i < n; i++) {
            dp[i] = n;
        }
        for(int i = 0; i < n; i++) {
            int j = Math.min(i + nums[i], n - 1);
            for(; j >= i; j--) {
                if(dp[j] < n)
                    break;
                dp[j] = dp[i] + 1;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.contains(2));
        return dp[n - 1];
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= nums[i]; j++) {
                if(i + j < n) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                } else {
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] test = {2,3,1,1,4};
        System.out.println((new jump()).jump(test));
    }
}
