import java.util.ArrayList;
import java.util.List;

public class diffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input.length() == 0) return res;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int j : left) {
                    for(int k : right) {
                        if (input.charAt(i) == '+') {
                            res.add(j + k);
                        } else if (input.charAt(i) == '-') {
                            res.add(j - k);
                        } else {
                            res.add(j * k);
                        }
                    }

                }
            }
        }
        if(res.size()==0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }

    public static void main(String[] args) {
        diffWaysToCompute c = new diffWaysToCompute();

        c.diffWaysToCompute("2-1-1");
    }

}
