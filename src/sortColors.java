import java.util.Arrays;

public class sortColors {
    public void sortColors(int[] nums) {
        int zero = -1;
        int one = 0;
        int two = nums.length;
        while(one < two) {
            if(nums[one] == 2) {
                two--;
                swap(nums, one, two);
            } else if(nums[one] == 1) {
                one++;
            } else if(nums[one] == 0) {
                zero++;
                swap(nums, zero, one);
                one++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        (new sortColors()).sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
