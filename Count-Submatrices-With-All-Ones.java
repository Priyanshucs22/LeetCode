class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = (i == 0 ? 1 : dp[i - 1][j] + 1);

                    int minH = dp[i][j];
                    for (int k = j; k >= 0 && dp[i][k] > 0; k--) {
                        minH = Math.min(minH, dp[i][k]);
                        sum += minH;
                    }
                }
            }
        }
        return sum;
    }
}
