import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    Stack<Integer> res;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        res = new Stack<>();
        for(NestedInteger i : nestedList) {
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            NestedInteger nestedInteger = stack.pop();
            if(nestedInteger.isInteger()) {
                res.push(nestedInteger.getInteger());
            } else {
                List<NestedInteger> list = nestedInteger.getList();
                for(NestedInteger i : list) {
                    stack.push(i);
                }
            }
        }
    }

    @Override
    public Integer next() {
        return res.pop();
    }

    @Override
    public boolean hasNext() {
        return !res.isEmpty();
    }
}