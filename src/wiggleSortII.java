import java.util.Arrays;

public class wiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int j = nums.length - 1;
        int k = (nums.length  - 1) / 2;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? temp[k--] : temp[j--];
        }
    }

    public void wiggleSortII(int[] nums) {

    }
}
