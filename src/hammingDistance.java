public class hammingDistance {
    public int hammingDistance(int x, int y) {
        String X = binary(x);
        String Y = binary(y);
        int res = 0;
        while(X.length() < Y.length()) {
            X = '0' + X;
        }
        while(Y.length() < X.length()) {
            Y = '0' + Y;
        }

        for(int i = 0; i < X.length(); i++) {
            if(X.charAt(i) != Y.charAt(i)) res++;
        }
        return res;
    }

    private String binary(int x) {
        StringBuilder sb = new StringBuilder();
        while(x > 0) {
            sb.append(x % 2);
            x /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        (new hammingDistance()).hammingDistance(1, 4);
    }
}
