import java.util.Stack;

public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; ++j) {
                height[j] = matrix[i][j] == '0' ? 0 : (1 + height[j]);
            }
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++) {
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] > heights[i])) {
                int top = stack.pop();
                int h = heights[top];
                int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
}
