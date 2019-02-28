import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class rotateArray {
    public void rotate(int[] nums, int k) {
        Queue q = new LinkedList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            q.add(nums[i]);
        }
        for(int i = 0; i < k; i++) {
            q.add(q.remove());
        }
        int i = nums.length - 1;
        while(!q.isEmpty()) {
            nums[i--] = (int)q.remove();
        }
    }

    public void rotate1(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums) {
            list.add(i);
        }
        for(int i = 0; i < k; i++) {
            int t  = list.remove(list.size() - 1);
            list.add(0, t);
        }
        for(int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }

    public void rotate3(int[] nums, int k) {
        for(int i = 0; i < k; i++) {
            int t = nums[nums.length - 1];
            for(int j = nums.length - 1; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = t;
        }
    }
}
