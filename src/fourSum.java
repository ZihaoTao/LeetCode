import java.util.*;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j != i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while(l < r) {
                    if(target == nums[i] + nums[j] + nums[l] + nums[r]) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l + 1] == nums[l]) l++;
                        while(l < r && nums[r - 1] == nums[r]) r--;
                        l++;
                        r--;
                    } else if (target < nums[i] + nums[j] + nums[l] + nums[r]) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
