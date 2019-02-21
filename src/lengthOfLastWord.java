public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        return str.length == 0 ? 0 : str[str.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println((new lengthOfLastWord()).lengthOfLastWord("hello world"));
    }
}
