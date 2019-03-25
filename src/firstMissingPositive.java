import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int index = binarySearch(nums, 1);
        if(index == - 1) return 1;
        for(int i = index + 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i] && nums[i - 1] + 1 != nums[i]) {
                return nums[i - 1] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    private int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int firstMissingPositive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int i : nums) {
            if(i > 0) {
                set.add(i);
                max = Math.max(max, i);
            }
        }
        for(int i = 1; i <= max; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }

    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println((new firstMissingPositive()).firstMissingPositive3(nums));
    }
}
