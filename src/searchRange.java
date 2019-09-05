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

    public int[] searchRange2(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        if(left > right || nums[left] != target || nums[right] != target) return new int[]{-1, -1};
        return new int[]{left, right};
    }

    private int findLeft(int[] nums, int target) {
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

    private int findRight(int[] nums, int target) {
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
}
