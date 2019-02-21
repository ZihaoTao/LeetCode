public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for(int i : nums) {
            count = Math.max(count + i, i);
            res = Math.max(res, count);
        }
        return res;
    }

    //int maxSubArray(int* nums, int numsSize) {
    //    int maxSum=nums[0],thisSum=nums[0];
    //    int i;
    //    for(i=1; i<numsSize; ++i){
    //        if(thisSum<0)
    //            thisSum=nums[i];
    //        else
    //            thisSum+=nums[i];
    //        if(thisSum>maxSum)
    //            maxSum = thisSum;
    //    }
    //    //if(maxSum<0)
    //     //   maxSum = 0;
    //    return maxSum;
    //}

    public static void main(String[] args) {
        int[] test = {-1, -1,  -3, 3, 1};
        System.out.println((new maxSubArray()).maxSubArray(test));
    }
}
