public class addDigits {
    public int addDigits(int num) {
        if(num < 10) return num;

        while(num > 9) {
            int sum = 0;
            int t = num;
            while(t > 0) {
                sum += t % 10;
                t /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println((new addDigits()).addDigits(28));
    }
}
