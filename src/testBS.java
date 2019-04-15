public class testBS {
    private int ceiling(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private int ceiling2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {-1, 0, 1, 2, 3};
        System.out.println((new testBS()).ceiling(test, 10));
        System.out.println((new testBS()).ceiling2(test, 10));
    }
}
