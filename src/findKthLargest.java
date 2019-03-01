public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, nums.length - k, 0, nums.length - 1);
    }

    private int helper(int[] nums, int k, int l, int r) {
        if(l > r) {
            return 0;
        }
        int p = partition(nums, l, r);
        if(p == k) {
            return nums[p];
        }
        return helper(nums, k, l, p - 1) + helper(nums, k, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int i = l + 1;
        int j = r;

        while(true) {
            while(i <= r && nums[i] < v) i++;
            while(j >= 0 && nums[j] > v) j--;
            if(i > j) break;
            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, l, j);
        return j;
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
