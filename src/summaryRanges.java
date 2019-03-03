import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0) return list;
        int[] dp = new int[nums.length];
        int pre = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != pre + 1) {
                count++;
            }
            dp[i] = count;
            pre = nums[i];
        }

        int r = -1;
        int l = 0;
        while(l < dp.length) {
            if(r + 1 < dp.length && dp[r + 1] == dp[l]) {
                r++;
            } else {
                String s = "" + nums[l];
                if(l != r) {
                    s += nums[l] + "->" + nums[r];
                }
                list.add(s);
                l = r + 1;
            }
        }
        return list;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0) return list;
        int l = 0;
        int r = 0;
        while(l < nums.length) {
            if(r + 1 < nums.length && nums[r + 1] == nums[r] + 1) {
                r++;
            } else {
                if(l == r) {
                    list.add("" + nums[l]);
                } else {
                    list.add(nums[l] + "->" + nums[r]);
                }
                l = r + 1;
                r++;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] s = {0, 1, 2, 4, 5, 7};
        (new summaryRanges()).summaryRanges2(s);
    }
}
