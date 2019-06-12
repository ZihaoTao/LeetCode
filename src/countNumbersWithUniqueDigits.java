import java.util.HashSet;
import java.util.Set;

public class countNumbersWithUniqueDigits {
    int count = 0;
    Set<Integer> set = new HashSet<>();
    public int countNumbersWithUniqueDigits(int n) {
        dfs(n, 0);
        return (int) Math.pow(10, n) - count;
    }

    private void dfs(int n, int index) {
        if(index == 0) {
            for(int i = 1; i <= 9; i++) {
                set.add(i);
                dfs(n, index + 1);
                set.remove(i);
            }
        } else if(index < n) {
            for (int i = 0; i <= 9; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    dfs(n, index + 1);
                    set.remove(i);
                } else {
                    count++;
                    if(n - index - 1 > 0) {
                        count += (int) Math.pow(10, n - index - 1);
                    }
                }
            }
        }
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if(n == 0) return 1;
        int unique = 10, cur_unique = 9;
        for(int i = 2; i <= n; ++i){
            cur_unique = cur_unique * (11 - i);
            unique += cur_unique;
        }
        return unique;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println((new countNumbersWithUniqueDigits()).countNumbersWithUniqueDigits(n));
        System.out.println((new countNumbersWithUniqueDigits()).countNumbersWithUniqueDigits2(n));
    }
}
