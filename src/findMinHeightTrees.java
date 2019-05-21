import java.util.*;

public class findMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(n == 1) {
            list.add(0);
            return list;
        }

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] degree = new int[n];

        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(degree[i] == 0) return list;
            if(degree[i] == 1) q.add(i);
        }

        while(!q.isEmpty()) {
            list = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int cur = q.remove();
                list.add(cur);
                degree[cur]--;
                for(int j = 0; j < graph.get(cur).size(); j++) {
                    int next = graph.get(cur).get(j);
                    if(degree[next] == 1) continue;
                    if(degree[next] == 2) {
                        q.add(next);
                    }
                    degree[next]--;
                }
            }
        }
        return list;
    }
}
