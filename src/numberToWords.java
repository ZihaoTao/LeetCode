public class numberToWords {
    public String numberToWords(int num) {
        String[] arr1 = {"", "Thousand ", "Million ", "Billion "};
        String[] arr2 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] arr3 = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String res = "";
        int thousand = 0;
        while(num > 0) {
            String s = "";
            int n = num % 1000;
            if(n != 0) {
                if(n / 100 > 0) {
                    s += arr2[n / 100] + "Hundred ";
                    n %= 100;
                }
                if(n >= 20) {
                    s += arr3[n / 10];
                    n %= 10;
                }
                s += arr2[n];
                res = s + arr1[thousand] + res;
            }
            thousand++;
            num /= 1000;
        }
        res = res.trim();
        return res.length() == 0 ? "Zero" : res;
    }

    public static void main(String[] args) {
        System.out.println((new numberToWords()).numberToWords(19));
    }
}
