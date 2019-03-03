import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nums {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0;
        int r = -1;
        while(l < nums.length) {
            if(r + 1 < nums.length && nums[r + 1] == nums[l]) {
                r++;
            } else {
                if(r - l + 1 > nums.length / 3) {
                    list.add(nums[l]);
                }
                l = r + 1;
            }
        }
        return list;
    }
}
