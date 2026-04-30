import java.util.*;

class Solution {
    int[][][] dp;

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -2); // -2 means unvisited
            }
        }

        int res = solve(grid, 0, 0, 0, k);
        return res < 0 ? -1 : res;
    }

    public int solve(int[][] g, int r, int c, int cost, int k) {
        int n = g.length, m = g[0].length;

        if (r >= n || c >= m) return -1;

        int nc = cost + (g[r][c] == 0 ? 0 : 1);
        if (nc > k) return -1;

        if (r == n - 1 && c == m - 1) {
            return g[r][c];
        }

        if (dp[r][c][cost] != -2) return dp[r][c][cost];

        int down = solve(g, r + 1, c, nc, k);
        int right = solve(g, r, c + 1, nc, k);

        int best = Math.max(down, right);

        if (best == -1) {
            return dp[r][c][cost] = -1;
        }

        return dp[r][c][cost] = g[r][c] + best;
    }
}