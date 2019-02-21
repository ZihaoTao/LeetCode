import java.util.Arrays;

public class removeDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int count = 1;
        int pre = nums[0];
        int j = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == pre) {
                if(count < 2){
                    nums[j++] = pre;
                    count++;
                }
            } else {
                pre = nums[i];
                nums[j++] = nums[i];
                count = 1;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] test = {0,0,1,1,1,1,2,3,3};
        System.out.println((new removeDuplicatesII()).removeDuplicates(test));
        System.out.println(Arrays.toString(test));

    }
}
