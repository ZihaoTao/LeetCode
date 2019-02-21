public class mySqrt {
    public int mySqrt(int x) {
        int l = 1, r = x, res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid * mid <= x ) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
