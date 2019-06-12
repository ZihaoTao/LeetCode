public class isAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0);
    }

    private boolean dfs(String num, int index) {
        if(index == num.length()) {
            return true;
        } else {
            for(int i = index + 1; i < num.length(); i++) {
                for(int j = i + 1; j < num.length(); j++) {
                    for(int k = j + 1; k <= num.length(); k++) {
                        int a = Integer.parseInt(num.substring(index, i));
                        int b = Integer.parseInt(num.substring(i, j));
                        int c = Integer.parseInt(num.substring(j, k));
                        if(a + b == c) {
                            if(dfs(num, index + 1)) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    private long parse(String s) {
        if (!s.equals("0") && s.startsWith("0")) return -1;
        long result;
        try {
            result = Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((new isAdditiveNumber()).isAdditiveNumber("199100199"));
    }
}
