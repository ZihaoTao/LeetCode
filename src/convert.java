public class convert {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        String res = "";
        int size = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < s.length(); j += size) {
                res += s.charAt(j);
                int temp = j + size - 2 * i;
                if(i != 0 && i != numRows - 1 && temp < s.length()) {
                    res += s.charAt(temp);
                }
            }
        }
        return res;
    }

    public String convert2(String s, int numRows) {
        if(numRows <= 1) return s;

        String[] strs = new String[numRows];
        for(int i = 0; i < strs.length; i++) {
            strs[i] = "";
        }

        int j = 0;
        int add = 1;
        for(int i = 0; i < s.length(); i++) {
            strs[j] += s.charAt(i);
            j += add;
            if(j == numRows - 1 || j == 0) {
                add = - add;
            }
        }
        String res = "";
        for(String i : strs) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        (new convert()).convert2("AB", 1);
    }
}
