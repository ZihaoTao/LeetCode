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

    private int flooring(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
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
        int[] test = {1};
        System.out.println((new testBS()).flooring(test, 0));
        System.out.println((new testBS()).ceiling(test, 0));

    }
}
