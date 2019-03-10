import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] has = new boolean[nums.length + 1];
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            has[i] = true;
        }
        for(int i = 1; i < has.length; i++) {
            if(!has[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
