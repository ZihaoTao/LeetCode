import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    //Find all possible combinations of k numbers that add up to a number n, given that only
    //numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
    //
    //Note:
    //
    //All numbers will be positive integers.
    //The solution set must not contain duplicate combinations.
    //Example 1:
    //
    //Input: k = 3, n = 7
    //Output: [[1,2,4]]
    //Example 2:
    //
    //Input: k = 3, n = 9
    //Output: [[1,2,6], [1,3,5], [2,3,4]]
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(k, n, 1, list);
        return res;
    }

    private void dfs(int k, int n, int index, List<Integer> list) {
        if(list.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for(int i = index; i <= 9; i++) {
                if(i <= n) {
                    list.add(i);
                    dfs(k, n - i, i + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = (new combinationSum3()).combinationSum3(3, 9);
        for(List<Integer> list : res) {
            System.out.println(list);
        }
    }

}
