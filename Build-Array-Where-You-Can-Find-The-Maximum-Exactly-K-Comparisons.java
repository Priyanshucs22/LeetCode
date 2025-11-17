class Solution {
    int N, M, K;
    int[][][] dp;
    int mod = 1000000007;

    int solve(int ind, int sr, int max) {
        if (ind == N) {
            if (sr == K) return 1;
            return 0;
        }
        if (dp[ind][sr][max] != -1) return dp[ind][sr][max];

        int res = 0;
        for (int i = 1; i <= M; i++) {
            if (i > max) {
                res = (res + solve(ind + 1, sr + 1, i)) % mod;
            } else {
                res = (res + solve(ind + 1, sr, max)) % mod;
            }
        }

        return dp[ind][sr][max] = res;
    }

    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        dp = new int[51][51][101];
        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, -1);
            }
        }
        return solve(0, 0, 0);
    }
}
