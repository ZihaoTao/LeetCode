public class testString {
    public void test() {
        String[] ss = new String[4];
        for(int i = 0; i < ss.length; i++) {
            ss[i] = "";
        }
        ss[3] += "ds";
        System.out.println(ss[3]);
    }

    public static void main(String[] args) {
        new testString().test();
    }
}
