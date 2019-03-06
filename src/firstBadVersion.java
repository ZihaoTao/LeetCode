public class firstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(0, n);
    }

    private int binarySearch(int l, int r) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isBadVersion(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
