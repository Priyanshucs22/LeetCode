class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        for(int[] arr:allowedSwaps){
            int u = find(arr[0], parent);
            int v = find(arr[1], parent);
            if(u != v){
                union(u, v, rank, parent);
            }
        }
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int p = find(i, parent);
            map.putIfAbsent(p, new HashMap<>());
            Map<Integer,Integer > freq = map.get(p);
            freq.put(source[i], freq.getOrDefault(source[i],0)+1);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int p = find(i, parent);
            Map<Integer,Integer> freq = map.get(p);
            if(freq.getOrDefault(target[i],0) > 0){
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                ans++;
            }
        }
        return ans;
    }
    int find(int u,int[] parent){
        if(parent[u] != u){
            parent[u] = find(parent[u], parent);
        }
        return parent[u];
    }
    void union(int a,int b,int[] rank,int[] parent){
        if(rank[a] > rank[b]){
            parent[b] = a;
        }
        else if(rank[b] > rank[a]){
            parent[a] = b;
        }
        else{
            parent[a] = b;
            rank[b]++;
        }
    }
}