import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = target - num;
            if(map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
            } else {
                map.put(num, i);
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            int res = binarySearch(nums, n, i + 1, nums.length - 1);
            if(res != -1) {
                int[] ret = {i + 1, res + 1};
                return ret;
            }
        }
        return null;
    }

    private int binarySearch(int[] nums, int n, int l, int r) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == n) {
                return mid;
            } else if(nums[mid] > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return  -1;
    }
}
