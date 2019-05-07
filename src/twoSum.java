import java.util.Arrays;
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

    public static void main(String[] args) {
        int[] test = {3, 2, 4};
        System.out.println(Arrays.toString((new twoSum()).twoSum(test, 6)));
    }
}
