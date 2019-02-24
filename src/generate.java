import java.util.ArrayList;
import java.util.List;

public class generate {
    List<List<Integer>> res;
    public List<List<Integer>> generate(int numRows) {
        res = new ArrayList<>();
        if(numRows == 0) return res;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        helper(numRows, list);
        return res;
    }

    private void helper(int numRows, List<Integer> list) {
        if(numRows > 0) {
            res.add(list);
            List<Integer> ret = new ArrayList<>();
            ret.add(1);
            for (int i = 0; i < list.size() - 1; i++) {
                ret.add(list.get(i) + list.get(i + 1));
            }
            ret.add(1);
            helper(numRows - 1, ret);
        }
    }
}
