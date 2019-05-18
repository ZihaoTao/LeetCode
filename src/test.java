import java.util.*;

public class test {
    List<Integer> list;
    public List<Integer> level(TreeNode root, int level) {
        list = new ArrayList<>();
        helper(root, level);
        return list;
    }

    private void helper(TreeNode node, int level) {
        if(node != null) {
            helper(node.left, level - 1);
            if(level == 0) list.add(node.val);
            helper(node.right, level - 1);
        }
    }

    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int a = 0;
        int b = 0;
        int c = 0;
        while(list.size() < n) {
            int min = Math.min(list.get(a) * 2, Math.min(list.get(b) * 3, list.get(c) * 5));
            list.add(min);
            if(min == list.get(a) * 2) a = list.size() - 1;
            else if(min == list.get(b) * 3) b = list.size() - 1;
            else c = list.size() - 1;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        int a = 0b1101;
        int b = 0b0100;

        System.out.println(a & b);  // 0100   all 1 is 1, or 0
        System.out.println(a ^ b);  // 1001   different is 1, or 0
        System.out.println(a | b);  // 1101   has 1 is 1, or 0
        System.out.println(~a); //0010  0 -> 1, 1 -> 0;
        System.out.println(a << 1); // 11010
        System.out.println(a >> 1); // 110 signed
        System.out.println(a >>> 1); // unsigned
        System.out.println(new Date());

        System.out.println((char)('A' + 32));
        System.out.println(String.valueOf("null"));


        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(-1024);
        stack2.push(512);
        System.out.println(stack1.peek() == stack2.peek());
        System.out.println(0b11111111111111111111111111111101);
        //3221225471 (10111111111111111111111111111111)

        (new test()).nthUglyNumber(10);


        String[] strs = new String[] { "A", "B", "C", "D" };

        // getting the list view of Array
        List<String> list = Arrays.asList(strs);
        System.out.println();
    }
}
