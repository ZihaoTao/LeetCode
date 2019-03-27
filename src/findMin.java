public class findMin {
    public int findMin(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] < nums[i]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    public int findMin2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r && nums[l] == nums[r]) {
            r--;
        }
        if(l == r) return nums[l];
        for(int i = 0; i < r; i++) {
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
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid;
            }
            if(mid + 1 == r) {
                return nums[r];
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] test = {2,2,2,0};
        System.out.println((new findMin()).findMin2(test));
    }
}
