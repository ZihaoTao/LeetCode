import java.util.ArrayList;
import java.util.List;

public class majorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i : nums) {
            if (i == candidate1) {
                count1++;
            } else if (i == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i : nums) {
            if(i == candidate1) {
                count1++;
            } else if(i == candidate2) {
                count2++;
            }
        }
        if(count1 > nums.length / 3) res.add(candidate1);
        if(count2 > nums.length / 3) res.add(candidate2);
        return res;
    }
}
