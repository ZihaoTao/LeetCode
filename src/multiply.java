public class multiply {
    public String multiply(String num1, String num2) {
       num1 = new StringBuilder(num1).reverse().toString();
       num2 = new StringBuilder(num2).reverse().toString();
       int[] temp = new int[num1.length() + num2.length()];
       for(int i = 0; i < num1.length(); i++) {
           for(int j = 0; j < num2.length(); j++) {
               temp[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
           }
       }

       int carry = 0;
       for(int i = 0; i < temp.length; i++) {
           temp[i] += carry;
           carry = temp[i] / 10;
           temp[i] %= 10;
       }

       StringBuilder sb = new StringBuilder();
       for(int i = temp.length - 1; i >= 0; i--) {
           sb.append(temp[i]);
       }

       while(sb.charAt(0) == '0' && sb.length() > 1) {
           sb.deleteCharAt(0);
       }
       return sb.toString();
    }

}
