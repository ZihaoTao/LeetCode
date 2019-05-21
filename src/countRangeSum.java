import java.util.Map;
import java.util.TreeMap;

public class countRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null || nums.length==0) return 0;
        TreeMap<Long, Long> tr = new TreeMap<Long, Long>();
        tr.put((long)0, (long)1);
        long sum = 0;
        long count = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Long> sub = tr.subMap(from, true, to, true);
            for(Long value:sub.values()){
                count+=value;
            }
            if(tr.containsKey(sum)){
                tr.put(sum, tr.get(sum)+1);
            } else {
                tr.put(sum, (long)1);
            }
        }
        return (int)count;
    }
}
