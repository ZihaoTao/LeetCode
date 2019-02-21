import java.util.Arrays;

public class plusOne {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if(carry == 0) {
            return digits;
        } else{
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for(int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString((new plusOne()).plusOne(digits)));
    }
}
