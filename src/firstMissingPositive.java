import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,3,1,0,4,0};
        System.out.println((new firstMissingPositive()).firstMissingPositive(nums));
    }
}
