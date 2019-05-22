public class isPowerOfThree {
    public boolean isPowerOfThree(int num) {
        return (Math.log10(num) / Math.log10(3)) % 1 == 0;
    }
}
