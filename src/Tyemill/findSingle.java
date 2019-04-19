package Tyemill;

import java.util.Arrays;

public class findSingle {
    public int findSingle(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int count = 1;
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == pre) {
                count++;
            } else {
                if(count == 1) return nums[i - 1];
                count = 1;
                pre = nums[i];
            }
        }
        return nums[nums.length - 1];
    }


    public static void main(String[] args) {
        int[] test = {1,3,2,1,6,4,4,2,3,4,0,0};
        System.out.println((new findSingle()).findSingle(test));
    }
}
