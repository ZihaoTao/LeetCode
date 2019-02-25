import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        Arrays.sort(nums);
        int count = 1;
        int res = 0;
        for(int i = 1; i <nums.length; i++) {
            if(nums[i - 1] == nums[i]) continue;
            if(nums[i - 1] + 1 != nums[i]) {
                res = Math.max(res, count);
                count = 1;
            } else {
                count++;
            }
        }
        return Math.max(res, count);
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int res = 0;
        for(int i : nums) {
            if(set.remove(i)) {
                int pre = i - 1;
                int next = i + 1;
                while(set.remove(pre)) {
                    pre--;
                }
                while(set.remove(next)) {
                    next++;
                }
                res = Math.max(res, next - pre + 1);
            }
        }
        return res;
    }
}
