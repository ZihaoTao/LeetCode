import java.util.*;

public class countSmaller {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        int n = nums.length;
        for(int i : nums) {
            set.add(i);
        }

        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : set) {
            map.put(i, rank++);
        }

        reverse(nums);
        int[] ranks = new int[n];
        for(int i = 0; i < n; i++) {
            ranks[i] = map.get(nums[i]) + 1;
        }

        int[] freq = new int[n + 1];
        NumArray numArray = new NumArray(freq);
        for(int i = 0; i < n; i++) {
            numArray.update(ranks[i], freq[ranks[i]] + 1);
            res.add(0, numArray.sumRange(0, ranks[i] - 1));
        }

        return res;
    }

    private void reverse(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] test = {5, 2, 6, 1};
        System.out.println((new countSmaller()).countSmaller(test));
    }
}
