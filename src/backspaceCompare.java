public class backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        String a = convert(S);
        String b = convert(T);
        return a.equals(b);
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '#') {
                count++;
            } else if (count != 0) {
                count--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((new backspaceCompare()).backspaceCompare("ab##", "c#d#"));
    }
}
