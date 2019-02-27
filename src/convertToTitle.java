public class convertToTitle {
    public String convertToTitle(int n) {
        String res = "";

        while(n != 0) {
            n--;
            res = (char)((n % 26) + 'A') + res;
            n /= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new convertToTitle()).convertToTitle(701));
    }
}
