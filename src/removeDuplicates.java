public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int index = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }




}
