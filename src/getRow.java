import java.util.ArrayList;
import java.util.List;

public class getRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while(rowIndex > 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int i = 0; i < res.size() - 1; i++) {
                temp.add(res.get(i) + res.get(i + 1));
            }
            temp.add(1);
            res = temp;
            rowIndex--;
        }
        return res;
    }
}
