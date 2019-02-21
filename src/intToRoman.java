public class intToRoman {
    // Greedy Algorithm
    public String intToRoman(int num) {
        String res = "";
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < val.length; i++) {
            while(num >= val[i]) {
                num -= val[i];
                res += strs[i];
            }
        }
        return res;
    }
}
