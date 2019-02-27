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

    public static void main(String[] args) {
        String s = "";
        System.out.println((new reverseWords()).reverseWords(s));
    }
}
