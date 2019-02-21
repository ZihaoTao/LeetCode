import java.util.Stack;

public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i = 0; i < heights.length; i++) {
            if(i + 1 < heights.length && heights[i + 1] > heights[i]) {
                continue;
            }
            int min = heights[i];
            for(int j = i; j >= 0; j--) {
                min = Math.min(min, heights[j]);
                res = Math.max(res, min * (i - j + 1));
            }
        }
        return res;
    }

    //[2,3]和[1,1,1,3,5]，而它们之间的最大解必然与[2,3,1,3,5]的解相同
    public static int largestRectangleArea2(int[] heights) {
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