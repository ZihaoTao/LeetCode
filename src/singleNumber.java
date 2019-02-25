import java.util.Arrays;

public class singleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
            } else {
                if(count == 1) return nums[i - 1];
                count = 1;
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 1, 2, 3, 3, 4};
        System.out.println((new singleNumber()).singleNumber(test));
    }
}
