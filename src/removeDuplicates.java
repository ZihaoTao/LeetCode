public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int j = 1;
        int res = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != res) {
                res = nums[i];
                nums[j++] = res;
                count++;
            }
        }
        return count;
    }
}
