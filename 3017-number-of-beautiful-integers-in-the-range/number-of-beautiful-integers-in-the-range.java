import java.util.*;

class Solution {
    int[][][][][][] dp;
    String s;
    int k;

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        return count(high) - count(low - 1);
    }

    int count(int x) {
        if (x < 0) return 0;
        s = Integer.toString(x);
        int n = s.length();
        dp = new int[n][2][k][n+1][n+1][2];
        for (int[][][][][] a : dp)
            for (int[][][][] b : a)
                for (int[][][] c : b)
                    for (int[][] d : c)
                        for (int[] e : d)
                            Arrays.fill(e, -1);

        return solve(0, 1, 0, 0, 0, 0);
    }

    int solve(int idx, int tight, int mod, int even, int odd, int started) {
        if (idx == s.length()) {
            if (started == 1 && mod == 0 && even == odd) return 1;
            return 0;
        }
        if (dp[idx][tight][mod][even][odd][started] != -1)
            return dp[idx][tight][mod][even][odd][started];
        int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int ans = 0;
        for (int d = 0; d <= limit; d++) {
            int nt = (tight == 1 && d == limit) ? 1 : 0;
            int ns = started;
            int ne = even, no = odd, nm = mod;
            if (started == 0 && d == 0) {
                ns = 0;
            } else {
                ns = 1;
                nm = (mod * 10 + d) % k;
                if (d % 2 == 0) ne++;
                else no++;
            }
            ans += solve(idx + 1, nt, nm, ne, no, ns);
        }
        return dp[idx][tight][mod][even][odd][started] = ans;
    }
}