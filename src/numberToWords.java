import java.util.LinkedList;
import java.util.Queue;

public class numberToWords {
    String[] one = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"};
    String[] ten = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        Queue<Integer> q = new LinkedList<>();
        Queue<String> qs = new LinkedList<>();

        while(num > 0) {
            q.add(num % 1000);
            num /= 1000;
        }
        while(!q.isEmpty()) {
            int n = q.remove();
            String s = convert(n);
            qs.add(s);
        }
        String res = "";
        int count = 0;
        while(!qs.isEmpty()) {
            String t = qs.remove();
            if(t.length() != 0) {
                if (count == 1) {
                    t += " Thousand ";
                }
                if (count == 2) {
                    t += " Million ";
                }
                if (count == 3) {
                    t += " Billion ";
                }
            }
            count++;
            res =  t + res;
        }
        if(res.length() == 0) return "Zero";
        res = res.trim();
        return res;
    }

    private String convert(int n) {
        String s = "";
        if(n > 99) {
            s += one[n / 100 - 1] + " Hundred ";
            n = n % 100;
        }
        if(n > 19) {
            s += ten[n / 10 - 2] + " ";
            n = n % 10;
        }
        if(n > 0) {
            s += one[n - 1] + " ";
        }
        return s.length() == 0 ? "" : s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println((new numberToWords()).numberToWords(1000000));
    }
}
