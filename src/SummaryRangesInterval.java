import java.util.Arrays;
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
        if(l != null && h != null && map.get(l).end + 1 == val && h == val + 1) {
            map.get(l).end = map.get(h).end;
            map.remove(h);
        } else if (l != null && map.get(l).end + 1 >= val) {
            map.get(l).end = Math.max(map.get(l).end, val);
        } else if (h != null && h == val + 1) {
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
            res[index][0] = map.get(i).start;
            res[index][1] = map.get(i).end;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRangesInterval summaryRangesInterval = new SummaryRangesInterval();
        summaryRangesInterval.addNum(2);
        summaryRangesInterval.addNum(3);
        summaryRangesInterval.addNum(4);
        summaryRangesInterval.addNum(4);
        for(int[] i : summaryRangesInterval.getIntervals()) {
            System.out.println(Arrays.toString(i));
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */