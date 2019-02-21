public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = {-1, -1};
        while(l <= r) {
            while(l < nums.length && nums[l] != target) {
                l++;
            }
            while(r > 0 && nums[r] != target) {
                r--;
            }
            if(l <= r) {
                res[0] = l;
                res[1] = r;
                return res;
            }
        }
        return res;
    }
}
