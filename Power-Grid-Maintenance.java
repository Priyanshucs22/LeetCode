class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : connections) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] comp = new int[c + 1];    
        boolean[] vis = new boolean[c + 1];
        int id = 1;
        for (int i = 1; i <= c; i++) {
            if (!vis[i]) {
                dfs(i, id, graph, vis, comp);
                id++;
            }
        }
        Map<Integer, TreeSet<Integer>> grid = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int group = comp[i];
            grid.putIfAbsent(group, new TreeSet<>());
            grid.get(group).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int group = comp[x];
            TreeSet<Integer> online = grid.get(group);

            if (type == 1) {
                if (online.contains(x)) {
                    ans.add(x);
                } else if (!online.isEmpty()) {
                    ans.add(online.first());
                } else {
                    ans.add(-1);
                }
            } else if (type == 2) {
                online.remove(x);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
    private void dfs(int node, int id, List<List<Integer>> graph, boolean[] vis, int[] comp) {
        vis[node] = true;
        comp[node] = id;
        for (int ne : graph.get(node)) {
            if (!vis[ne]) {
                dfs(ne, id, graph, vis, comp);
            }
        }
    }
}