import java.util.Arrays;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, j++);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] test = {1,0};
        (new moveZeroes()).moveZeroes(test);
        System.out.println(Arrays.toString(test));
    }
}
