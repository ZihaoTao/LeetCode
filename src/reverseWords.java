public class reverseWords {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for(int i = ss.length - 1; i >= 0; i--) {
            if(ss[i].length() != 0) {
                sb.append(ss[i] + " ");
            }
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        int l = 0;
        int r = -1;
        String str = "";
        while(l < s.length()) {
            if(r + 1 < s.length() && s.charAt(r + 1) != ' ') {
                while(r + 1 < s.length() && s.charAt(r + 1) != ' ') {
                    r++;
                }
            } else {
                r++;
                if(l < r) str = " " + s.substring(l, r) + str;
                l = r + 1;
            }
        }
        return str.length() == 0 ? "" : str.substring(1);
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println((new reverseWords()).reverseWords(s));
    }
}
