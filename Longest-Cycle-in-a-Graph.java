class Solution {
    int max = -1;
    int[] depth;
    boolean[] vis;
    boolean[] rec;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        vis = new boolean[n];
        rec = new boolean[n];
        depth = new int[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(edges, i);
            }
        }
        return max;
    }
    void dfs(int[] edges, int node) {
        vis[node] = true;
        rec[node] = true;
        int next = edges[node];
        if (next != -1) {
            if (!vis[next]) {
                depth[next] = depth[node]+1;
                dfs(edges, next);
            } else if (rec[next]) {
                max = Math.max(max, depth[node] - depth[next] + 1);
            }
        }
        rec[node] = false;
    }
}
