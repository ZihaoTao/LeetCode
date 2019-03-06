public class VersionControl {
    public boolean isBadVersion(int version) {
        boolean[] test = {true, true, true, true, false, false, false};
        return test[version];
    }
}
