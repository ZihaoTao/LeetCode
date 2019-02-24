import java.util.List;

public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int n = triangle.get(row - 1).size();
        int[] dp = new int[n + 1];
        for(int i = row - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
