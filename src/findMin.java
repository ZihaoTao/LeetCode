public class findMin {
    public int findMin(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] < nums[i]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    // binarySearch

    public int findMin3(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
            if(l == r + 1) return nums[l];
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] test = {2,2,2,0};
        System.out.println((new findMin()).findMin3(test));
    }
}
