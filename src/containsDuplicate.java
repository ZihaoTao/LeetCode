import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(!set.contains(i)) {
                set.add(i);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if(binarySearch(nums, i + 1, nums.length - 1, t) != -1) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        if(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                return binarySearch(nums, mid + 1, r, target);
            } else {
                return binarySearch(nums, l, mid - 1, target);
            }
        }
        return -1;
    }
}
