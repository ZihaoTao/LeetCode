import java.util.Stack;

public class simplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String i : strs) {
            if(i.length() != 0) {
                if (!i.equals("..") && !i.equals(".")) {
                    stack.push(i);
                } else if (i.equals("..") && !stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        String res = "";
        while(!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;
    }

    public static void main(String[] args) {
        System.out.println((new simplifyPath()).simplifyPath("/a/./b/../../c/"));
    }
}
