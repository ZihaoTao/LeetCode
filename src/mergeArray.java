public class mergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r = nums1.length - 1;
        while(m > 0 || n > 0) {
            if(m == 0) {
                nums1[r] = nums2[--n];
            } else if(n == 0) {
                nums1[r] = nums1[--m];
            } else if(nums1[m - 1] > nums2[n - 1]) {
                nums1[r] = nums1[--m];
            } else {
                nums1[r] = nums2[--n];
            }
            r--;
        }
    }
}
