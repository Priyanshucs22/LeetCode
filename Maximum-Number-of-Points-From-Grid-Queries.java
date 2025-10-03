class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] ans = new int[queries.length];
        int r = grid.length, c = grid[0].length;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        
        int[][] arr = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        
        int cnt = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] vis = new boolean[r][c];
        vis[0][0] = true;
        q.add(new int[]{0,0,grid[0][0]});
        
        for(int[] a:arr){
            int e = a[0], ind = a[1];
            while(!q.isEmpty() && q.peek()[2] < e){
                int[] t = q.poll();
                int x = t[0], y = t[1];
                cnt++;
                for(int[] d:dir){
                    int nx = x+d[0], ny = y+d[1];
                    if(nx>=0 && nx<r && ny>=0 && ny<c && !vis[nx][ny]){
                        vis[nx][ny] = true;
                        q.add(new int[]{nx,ny,grid[nx][ny]});
                    }
                }
            }
            ans[ind] = cnt;
        }
        return ans;
    }
}
