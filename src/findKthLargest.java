public class findKthLargest {
    int res;
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        helper(nums, l, r, k);
        return res;
    }

    private void helper(int[] nums, int l, int r, int k) {
        if(l > r) return;
        int p = partition(nums, l, r);
        if(p == k - 1) {
            res = nums[p];
            return;
        }
        helper(nums, l, p - 1, k);
        helper(nums, p + 1, r, k);

    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int i = l + 1;
        int j = r;
        while(true) {
            while(i <= r && nums[i] > v) i++;
            while(j >= l && nums[j] < v) j--;
            if(i > j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
