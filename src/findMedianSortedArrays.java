public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n) / 2;
        int right = (m + n) / 2 + 1;
        if((m + n) % 2 == 0) {
            return (helper(nums1, 0, nums2, 0, left) + helper(nums1, 0, nums2, 0, right)) / 2.0;
        } else {
            return helper(nums1, 0, nums2, 0, left);
        }
    }

    private int helper(int[] nums1, int i, int[] nums2, int j, int k) {
        if(i >= nums1.length) return nums2[j + k - 1];
        if(j >= nums2.length) return nums1[i + k - 1];
        if(k == 1) return Math.min(nums1[i], nums2[j]);
        int mid1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return helper(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return helper(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length || j < nums2.length) {
            if(i < nums1.length && j < nums2.length) {
                if(nums1[i] < nums2[j]) {
                    num[k++] = nums1[i++];
                } else {
                    num[k++] = nums2[j++];
                }
            } else if(i < nums1.length) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        if(num.length % 2 == 1) {
            return num[num.length / 2];
        } else {
            return (double)(num[num.length / 2] + num[num.length / 2 - 1]) / 2;
        }
    }

}
