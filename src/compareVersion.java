public class compareVersion {
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");
        int len = Math.max(vs1.length, vs2.length);
        int[] n = new int[len];
        for(int i = 0; i < len; i++) {
            if(i < vs1.length && i <vs2.length) {
                n[i] = Integer.parseInt(vs1[i]) - Integer.parseInt(vs2[i]);
            }
            if(i >= vs1.length) {
                n[i] = - Integer.parseInt(vs2[i]);
            }
            if(i >= vs2.length) {
                n[i] = Integer.parseInt(vs1[i]);
            }
        }

        for(int i : n) {
            if(i != 0) {
                return i > 0 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "1.1";
        String s2 = "1";
        System.out.println((new compareVersion()).compareVersion(s1, s2));
    }
}
