public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] b = new int[n];
        f[0] = 1;
        b[n - 1] = 1;
        for(int i = 1; i < n; i++) {
            f[i] = nums[i - 1] * f[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            b[i] = nums[i + 1] * b[i + 1];
        }
        for(int i = 0; i < n; i++) {
            b[i] = b[i] * f[i];
        }
        return b;
    }
}
