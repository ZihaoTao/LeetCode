public class isPowerOfX {
    public boolean isPowerOfX(int num, int X) {
        return (Math.log10(num) / Math.log10(X)) % 1 == 0;
    }
}
