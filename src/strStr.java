public class strStr {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if(len == 0) return 0;
        int l = 0, r = len;
        while(r <= haystack.length()) {
            if(haystack.substring(l, r + 1).equals(needle)) {
                return l;
            }
            l++;
            r++;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println((new strStr()).strStr("abaa", ""));
    }
}
