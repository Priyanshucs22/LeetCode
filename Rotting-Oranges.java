class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int r = grid.length;
        int c = grid[0].length;
        int fr = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <c; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
                if(grid[i][j]==1) fr++;
            }
        }
        if(fr==0) return 0;
        int t = 0;
        boolean rot = false;
        while (!q.isEmpty()) {
            int size = q.size();
            rot = false;
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                int a = p[0];
                int b = p[1];
                for (int[] d : dirs) {
                    int x = d[0] + a;
                    int y = d[1] + b;
                    if (x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == 1) {
                        grid[x][y] = 0;
                        fr--;
                        q.add(new int[]{x,y});
                        rot = true;
                    }
                }
            }
            if(rot) t++;
        }
        return fr==0 ? t : -1;
    }
}