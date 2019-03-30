// JAVA program for implementation of KMP pattern
// searching algorithm

class KMP_String_Matching {
    public void KMPSearch(String pattern, String t) {
        int m = pattern.length();
        int n = t.length();

        int[] prefix = new int[m];
        int j = 0;

        prefixTable(pattern, m, prefix);

        int i = 0;
        while (i < n) {
            if (pattern.charAt(j) == t.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println(i - j);
                j = prefix[j - 1];
            } else if (i < n && pattern.charAt(j) != t.charAt(i)) {
                if (j != 0) {
                    j = prefix[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public void prefixTable(String pattern, int m, int[] prefix) {
        int len = 0;
        int i = 1;
        prefix[0] = 0;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String args[]) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP_String_Matching().KMPSearch(pat, txt);
    }
}
