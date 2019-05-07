public class multiply {
    public String multiply(String num1, String num2) {
        num1 = (new StringBuilder(num1)).reverse().toString();
        num2 = (new StringBuilder(num2)).reverse().toString();
        int[] nums = new int[num1.length() + num2.length()];
        for(int i = 0; i < num1.length(); i++) {
            for(int j = 0; j < num2.length(); j++) {
                nums[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for(int j = 0; j < nums.length; j++) {
            int temp = (nums[j] + carry) / 10;
            nums[j] = (nums[j] + carry) % 10;
            carry = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < nums.length; j++) {
            sb.append(nums[j]);
        }
        while(sb.length() != 0 && sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println((new multiply()).multiply("0", "0"));
    }

}
