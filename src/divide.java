public class divide {
    public long divide(int dividend, int divisor) {
        int count = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        while(a >= b) {
            a -= b;
            int temp = count + 1;
            if(temp - 1 != count) break;
            count = temp;
        }
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -count;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println((new divide()).divide(-2147483648, -1));
    }
}
