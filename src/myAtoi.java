public class myAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        int i = 0;
        boolean isNeg = false;
        if(str.charAt(i) == '+') {
            i++;
        } else if(str.charAt(i) == '-') {
            i++;
            isNeg = true;
        }
        double res = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + str.charAt(i) - '0';
            i++;
        }
        if(isNeg) {
            res = -res;
        }
        if(res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)res;
    }
}
