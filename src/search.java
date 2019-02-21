public class search {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < nums[r]) {
                if(nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if(nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public boolean searchII(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[r]) {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if(nums[mid] > nums[r]){
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                r--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {3, 1, 1};
        System.out.println((new search()).searchII(test, 3));
    }
}
