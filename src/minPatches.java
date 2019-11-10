import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minPatches {
    public int minPatches(int[] nums, int n) {
        int cnt = 0;
        int i = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                ++cnt;
                miss *= 2;
            }
        }
        return cnt;
    }
}
