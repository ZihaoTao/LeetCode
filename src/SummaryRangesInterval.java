import java.util.TreeMap;

class SummaryRangesInterval {
    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public SummaryRangesInterval() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if(map.containsKey(val)) return;
        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);
        if(l != null && h != null && map.get(l).end + 1 == val && val + 1 == h) {
            map.get(l).end = map.get(h).end;
            map.remove(h);
        } else if(l != null && map.get(l).end + 1 >= val) {
            map.get(l).end = Math.max(map.get(l).end, val);
        } else if (h != null && val + 1 == h) {
            map.put(val, new Interval(val, map.get(h).end));
            map.remove(h);
        } else {
            map.put(val, new Interval(val, val));
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int index = 0;
        for(int i : map.keySet()) {
            Interval interval = map.get(i);
            res[index][0] = interval.start;
            res[index][1] = interval.end;
            index++;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */