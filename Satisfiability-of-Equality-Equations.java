class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        for(int i=0;i<26;i++) parent[i] = i;
        for(String s:equations){
            if(s.charAt(1)=='='){
                int a = s.charAt(0)-'a';
                int b = s.charAt(3)-'a';
                union(parent,rank,a,b);
            }
        }
        for(String s:equations){
            if(s.charAt(1)=='!'){
                int a = s.charAt(0)-'a';
                int b = s.charAt(3)-'a';
                if(find(a,parent)==find(b,parent)) return false;
            }
        }
        return true;
    }
    int find(int u,int[] parent){
        if(parent[u]!=u){
            return parent[u] = find(parent[u],parent);
        }
        return parent[u];
    }
    void union(int[] parent,int[] rank,int x,int y){
        int xp = find(x,parent);
        int yp = find(y,parent);
        if(xp == yp) return;
        if(rank[xp]>rank[yp]){
            parent[yp] = xp;
        }
        else if(rank[yp]>rank[xp]){
            parent[xp] = yp;
        }
        else{
            parent[xp] = yp;
            rank[yp]++;
        }
    }
}