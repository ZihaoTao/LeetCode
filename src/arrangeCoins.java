public class arrangeCoins {

    public int arrangeCoins(int n) {
        int i = 1;
        int sum = 0;
        while(sum <= n) {
            sum += i;
            i++;
        }
        return i - 2;
    }

    public static void main(String[] args) {
        System.out.println((new arrangeCoins()).arrangeCoins(2147483647));
    }

}
