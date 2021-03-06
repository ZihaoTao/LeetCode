import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class getPermutation {
    List<String> res;
    Set<Integer> set;
    public String getPermutation(int n, int k) {
        res = new ArrayList<>();
        if(n == 0) return "";
        set = new HashSet<>();
        dfs(n,"");
        return res.get(k - 1);
    }

    private void dfs(int n, String s) {
        if(n == s.length()) {
            res.add(s);
        } else {
            for(int i = 1; i <= n; i++) {
                if(!set.contains(i)) {
                    set.add(i);
                    s += i;
                    dfs(n, s);
                    s = s.substring(0, s.length() - 1);
                    set.remove(i);
                }
            }
        }
    }

    public String getPermutation2(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        for(int i = 0; i < k; i++) {
            nums = nextPermutation(nums);
        }
        String s = "";
        for(int i : nums) {
            s += i;
        }
        return s;
    }


    public int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    private void reverse(int[] nums, int l) {
        int r = nums.length - 1;
        while(l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
