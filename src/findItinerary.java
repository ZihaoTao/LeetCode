import java.util.*;

public class findItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> i : tickets) {
            if(!map.containsKey(i.get(0))) {
                map.put(i.get(0), new PriorityQueue<>());
            }
            map.get(i.get(0)).add(i.get(1));
        }
        Stack<String> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).remove());
            }
            res.add(0, stack.pop());
        }
        return res;
    }
}
