class Solution {
    int[][][] dp;
    public int countDigitOne(int n) {
        dp = new int[10][2][10];
        for(int[][] d:dp){
            for(int[] a:d){
                Arrays.fill(a,-1);
            }
        }
        return solve(Integer.toString(n), 0, 1, 0);
    }
    public int solve(String s, int idx, int tight, int cnt) {
        if (idx == s.length()) return cnt;
        if(dp[idx][tight][cnt] != -1) return dp[idx][tight][cnt];
        int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            int upd = cnt + (i == 1 ? 1 : 0);
            int newTight;
            if (tight == 1 && i == limit) newTight = 1;
            else newTight = 0;
            ans += solve(s, idx + 1, newTight, upd);
        }
        return dp[idx][tight][cnt] = ans;
    }
}