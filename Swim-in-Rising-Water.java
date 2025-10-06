class Solution {
    public int swimInWater(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] vis= new boolean[r][c];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
        pq.add(new int[]{0,0,grid[0][0]});
        int ans = 0;
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int i = p[0];
            int j = p[1];
            int t = p[2];
            ans = Math.max(ans,t);
            if(i==r-1 && j==c-1) return ans;
            vis[i][j] = true;
            for(int[] d:dir){
                int x = i + d[0];
                int y = j + d[1];
                if(x>=0 && x<r && y>=0 && y<c &&!vis[x][y]){
                    pq.add(new int[]{x,y,grid[x][y]});
                }
            }
        }
        return 0;
    }
}