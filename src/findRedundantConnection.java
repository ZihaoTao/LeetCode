public class findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        QuickUnion qu = new QuickUnion(m + 1);
        for(int i = 0; i < m; i++) {
            int[] nums = edges[i];
            if(qu.isConnected(nums[0], nums[1])) {
                return nums;
            } else {
                qu.unionElements(nums[0], nums[1]);
            }
        }
        return new int[]{};
    }


    public class QuickUnion {
        private int[] parent;
        private int count;
        private int[] rank; // rank[i]: the level of the tree whose root is i

        public QuickUnion(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            assert(p >= 0 && p <= count);
            //        while (p != parent[p]) {
            //            parent[p] = parent[parent[p]];
            //            p = parent[p];
            //        }
            //        return p;
            // path compression
            if(parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if(rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if(rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                // rank[pRoot] == rank[qRoot]
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }
        }
    }
}
