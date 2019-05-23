public class wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] up = new int[n];
        int[] down = new int[n];
        for(int i = 0; i < n; i++) {
            up[i] = 1;
            down[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                } else if(nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                }
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
