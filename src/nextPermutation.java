public class nextPermutation {
    public void nextPermutation(int[] nums) {
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

    //void nextPermutation(vector<int> &num) {
    //        int i, j, n = num.size();
    //        for (i = n - 2; i >= 0; --i) {
    //            if (num[i + 1] > num[i]) {
    //                for (j = n - 1; j > i; --j) {
    //                    if (num[j] > num[i]) break;
    //                }
    //                swap(num[i], num[j]);
    //                reverse(num.begin() + i + 1, num.end());
    //                return;
    //            }
    //        }
    //        reverse(num.begin(), num.end());
    //    }
}
