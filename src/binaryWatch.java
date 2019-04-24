import java.util.*;

public class binaryWatch {
    int[] arr = {100, 200, 400, 800, 1, 2, 4, 8, 16, 32};
    List<String> res;
    Set<Integer> set;
    Set<Integer> sset;

    public List<String> readBinaryWatch(int num) {
        res = new ArrayList<>();
        set = new HashSet<>();
        sset = new HashSet<>();
        dfs(num, 0, 0);
        return res;
    }

    private void dfs(int num, int index, int sum) {
            if (sum < 1200 && sum % 100 < 60) {
                if (index == num) {
                    if (!sset.contains(sum)) {
                        sset.add(sum);
                        res.add(convert(sum));
                    }
                } else {
                for (int i = 0; i < arr.length; i++) {
                    if (!set.contains(i)) {
                        set.add(i);
                        dfs(num, index + 1, sum + arr[i]);
                        set.remove(i);
                    }
                }
            }
        }
    }

    private String convert(int num) {
        int hour = num / 100;
        int min = num % 100;
        if(min < 10) return hour + ":0" + min;
        return hour + ":" + min;
    }

    public static void main(String[] args) {
        System.out.println((new binaryWatch()).readBinaryWatch(2));
        String[] test = {"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
        System.out.println(Arrays.toString(test));
    }
}
