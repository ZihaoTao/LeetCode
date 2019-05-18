import java.util.TreeSet;

public class containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i - k - 1 >= 0) set.remove((long) nums[i - k - 1]);
            Long temp;
            temp = set.ceiling((long) nums[i]);
            if(temp != null && temp - nums[i] <= t) return true;
            temp = set.floor((long) nums[i]);
            if(temp != null && nums[i] - temp <= t) return true;
            set.add((long) nums[i]);
        }
        return false;
    }
}
