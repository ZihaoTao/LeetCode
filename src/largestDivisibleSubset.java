import java.util.*;

public class largestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        res.add(nums[0]);
        int len = 1;
        for(int i = 0; i < nums.length; i++) {
            map.put(i, new ArrayList<Integer>());
            map.get(i).add(nums[i]);
            for(int j = 0; j < i; j++) {

                if(nums[i] % nums[j] == 0) {
                    if(map.get(j).size() + 1 > map.get(i).size()) {
                        List<Integer> list = new ArrayList<>(map.get(j));
                        map.put(i, list);
                        map.get(i).add(nums[i]);
                    }
                    if(map.get(i).size() > len) {

                        res = map.get(i);
                        len = res.size();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,2,4,8, 5,7};
        System.out.println((new largestDivisibleSubset()).largestDivisibleSubset(test));
    }
}
