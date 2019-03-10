import java.util.*;

public class leastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char i : tasks) {
            freq[i - 'A']++;
        }
        Arrays.sort(freq);
        int i = 25;
        int mx = freq[25];
        int len = tasks.length;
        while(i >= 0 && freq[i] == mx) i--;
        return Math.max(len, (mx - 1) * (n + 1) + 25 - i);
    }
}
