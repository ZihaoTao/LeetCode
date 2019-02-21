public class partitionDisjoint {
    public int partitionDisjoint(int[] A) {
        int max = findMax(A, 0, A.length - 1);

        int min = Integer.MAX_VALUE;
        int res = A.length;
        for(int i = A.length - 1; i >= 0; i--) {
            min = Math.min(min, A[i]);
            if(A[i] == max) {
                max = findMax(A, 0, i - 1);
            }
            if(min >= max && i != 0) {
                res = i;
            }
        }
        return res;
    }

    private int findMax(int[] nums, int l, int r) {
        int res = Integer.MIN_VALUE;
        if(l > r) return nums[l];
        for(int i = l; i <= r; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,1};
        System.out.println((new partitionDisjoint()).partitionDisjoint(A));
    }
}
