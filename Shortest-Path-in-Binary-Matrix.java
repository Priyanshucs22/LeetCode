class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length-1;
        if (grid[0][0] == 1 || grid[n][n] == 1) return -1; 
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        int len = Integer.MAX_VALUE;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        grid[0][0] = 1;
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int a = pair[0];
            int b = pair[1];
            int path = pair[2];
            if(a == n && b == n) len = Math.min(len,path);
            for(int[] d:dirs){
                int x = d[0] + a;
                int y = d[1] + b;
                if(x>=0 && x<=n && y>=0 && y<=n && grid[x][y]==0){
                    q.add(new int[]{x,y,path+1});
                    grid[x][y] = 1;
                }
            }
        }
        if(len!=Integer.MAX_VALUE) return len;
        return -1;
    }
}