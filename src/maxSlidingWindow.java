import java.util.ArrayList;
import java.util.List;

public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int l = 0;
        int r = k - 1;
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r && i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        list.add(max);
        while(r + 1 < nums.length) {
            if(nums[l] == max) {
                max = Integer.MIN_VALUE;
                for(int i = l + 1; i <= r + 1; i++) {
                    max = Math.max(max, nums[i]);
                }
            }
            if(nums[r + 1] > max) {
                max = nums[r + 1];
            }
            list.add(max);
            l++;
            r++;
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {9,10,9,-7,-4,-8,2,-6};
        (new maxSlidingWindow()).maxSlidingWindow(test, 5);
    }
}
