class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int[] e : sources){
            ans[e[0]][e[1]] = e[2];
            q.add(new int[]{e[0], e[1]});
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            HashMap<String, Integer> map = new HashMap<>();
            while(size-- > 0){
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];
                for(int[] d : dir){
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && ans[nx][ny]==0){
                        String key = nx + "," + ny;
                        map.put(key, Math.max(map.getOrDefault(key, 0), ans[x][y]));
                    }
                }
            }
            for(String key : map.keySet()){
                String[] parts = key.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                ans[x][y] = map.get(key);
                q.add(new int[]{x, y});
            }
        }
        return ans;
    }
}