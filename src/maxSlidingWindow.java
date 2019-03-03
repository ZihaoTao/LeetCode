import java.util.ArrayList;

public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length == 0) return new int[0];
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        for(r = 0; r < k; r++) {
            max = Math.max(max, nums[r]);
        }
        list.add(max);
        r--;
        while(r + 1 < nums.length) {
            r++;
            int remove = nums[l];
            int add = nums[r];
            l++;
            if(add > max) {
                max = add;
            }
            if(remove == max) {
                max = find(nums, l, r);
            }
            list.add(max);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int find(int[] nums, int l, int r) {
        int res = Integer.MIN_VALUE;
        for(int i = l; i <= r; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {9,10,9,-7,-4,-8,2,-6};
        (new maxSlidingWindow()).maxSlidingWindow(test, 5);
    }
}
