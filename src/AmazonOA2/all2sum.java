package AmazonOA2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class all2sum {
    public List<Pair<Integer, Integer>> all2sum(int[] nums, int target) {
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] <= target) {
                    res.add(new Pair<>(nums[i], nums[j]));
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 4, 6, 2, 7, 9};
        System.out.println((new all2sum()).all2sum(test, 10));
    }
}
