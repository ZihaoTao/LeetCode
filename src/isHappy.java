import java.util.HashSet;
import java.util.Set;

public class isHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1) {
            if(!set.contains(n)) {
                set.add(n);
                int t = 0;
                while(n > 0) {
                    t += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = t;
            } else {
                return false;
            }
        }
        return true;
    }
}
