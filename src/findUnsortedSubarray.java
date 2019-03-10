import java.util.Arrays;

public class findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] t = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            t[i] = nums[i];
        }

        Arrays.sort(t);
        int l = 0;
        int r = nums.length - 1;
        while(l < nums.length) {
            if(nums[l] != t[l]) {
                break;
            }
            l++;
        }

        while(r >= 0) {
            if(nums[r] != t[r]) {
                break;
            }
            r--;
        }

        int res = r - l + 1;
        return res < 0 ? 0 : res;
    }
}
