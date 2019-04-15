package Tyemill;

import java.util.Arrays;

public class findSingle {
    public int findSingle(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) i++;
            else return nums[i];
        }
        return nums[nums.length - 1];
    }


    public static void main(String[] args) {
        int[] test = {1,3,2,1,6,4,2,3,4};
        System.out.println((new findSingle()).findSingle(test));
    }
}
