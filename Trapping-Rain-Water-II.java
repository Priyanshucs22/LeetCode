class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int r = heightMap.length;
        int c = heightMap[0].length;
        boolean[][] vis = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 || i==r-1 || j==0 || j==c-1){
                    pq.offer(new int[]{i,j,heightMap[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int ans = 0;
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int x = top[0];
            int y = top[1];
            int h = top[2];
            for(int[] d:dir){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx>=0 && nx<r && ny>=0 && ny<c && !vis[nx][ny]){
                    ans += Math.max(h - heightMap[nx][ny] , 0);
                    vis[nx][ny] = true;
                    pq.offer(new int[]{nx,ny,Math.max(h,heightMap[nx][ny])});
                }
            }
        }
        return ans;
    }
}