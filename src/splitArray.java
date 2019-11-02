import java.util.Arrays;

public class splitArray {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        return (int)binary(nums, m, max, sum);
    }

    private long binary(int[] nums, int m, long l, long r){
        while(l <= r){
            long mid = l + (r - l) / 2;
            if(valid(nums, m, mid)){
                //System.out.println(mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean valid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        for(int num: nums){
            cur += num;
            if(cur > max){
                cur = num;
                count++;
                if(count > m){
                    return false;
                }
            }
        }
        return true;
    }

    public int splitArray2(int[] nums, int m) {
        int[][] dp = new int[nums.length + 1][m + 1];
        long[] sum = new long[nums.length + 1];
        // dp[i][j] 0~i numbers split into j groups, the min value of
        // all possible max value of sums of j groups
        for(int i = 1; i <= nums.length; i++) {
            dp[i][1] = dp[i - 1][1] + nums[i - 1];
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for(int i = 2; i <= m; i++) {
            for(int j = i; j <= nums.length; j++) {
                dp[j][i] = Integer.MAX_VALUE;
                for(int k = 1; k < j; k++) {
                    int t = (int) Math.min(dp[j][i], Math.max(dp[k][i - 1], sum[j] - sum[k]));
                    if(t < dp[j][i]) {
                        dp[j][i] = t;
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[nums.length][m];
    }

    public static void main(String[] args) {
        int[] nums = {1, Integer.MAX_VALUE};
        System.out.println((new splitArray()).splitArray(nums, 2));
        System.out.println((new splitArray()).splitArray2(nums, 2));
    }
}
