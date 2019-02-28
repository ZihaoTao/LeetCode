public class minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int count = 0;
        int res = nums.length + 1;
        while(l < nums.length) {
            if(r + 1 < nums.length && count < s) {
                count += nums[++r];
            } else {
                if(count >= s) res = Math.min(res, r - l + 1);
                count -= nums[l++];
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }

    public int minSubArrayLen2(int s, int[] nums) {
       int[] sum = new int[nums.length + 1];
       for(int i = 1; i < sum.length; i++) {
           sum[i] = sum[i - 1] + nums[i - 1];
       }
       int res = sum.length;
       for(int i = 0; i < nums.length; i++) {
           int index = search(sum, sum[i] + s, i + 1, sum.length - 1);
           if(index == sum.length) break;
           res = Math.min(res, index - i);
       }
       return res == sum.length ? 0 : res;
    }

    private int search(int[] nums, int target, int l, int r) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }



    public static void main(String[] args) {
        int[] test = {1, 4, 4};
        System.out.println((new minSubArrayLen()).minSubArrayLen2(4, test));
    }
}
