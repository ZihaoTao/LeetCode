public class divide {
    public int divide(int dividend, int divisor) {
        int count = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        while(a > b) {
            a -= b;
            count++;
        }
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -count;
        } else {
            return count;
        }
    }
}
