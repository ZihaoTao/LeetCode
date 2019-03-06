import java.util.Arrays;

public class singleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int index = 0;
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
            } else {
                if(count == 1) res[index++] = nums[i - 1];
                if(i == nums.length - 1 && index == 1) res[1] = nums[i];
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,2,1,3,2,5};
        System.out.println(Arrays.toString((new singleNumberIII()).singleNumber(test)));
    }
}
