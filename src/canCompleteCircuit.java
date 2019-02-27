public class canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for(int i = 0; i < diff.length; i++) {
            diff[i] = gas[i] - cost[i];
        }

        for(int i = 0; i < diff.length; i++) {
            int start = i;
            int count = 0;
            int j;
            for(j = 0; j < diff.length; j++) {
                if(start == diff.length) start = 0;
                count += diff[start++];
                if(count < 0) break;
            }
            if(j == diff.length) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int cur = 0;
        int res = 0;
        int val = 0;
        for (int i = 0; i < gas.length; ++i) {
            cur += gas[i] - cost[i];
            val += gas[i] - cost[i];
            if (cur < 0) {
                res = i + 1;
                cur = 0;
            }
        }
        if (val >= 0) return res;
        return -1;
    }
}
