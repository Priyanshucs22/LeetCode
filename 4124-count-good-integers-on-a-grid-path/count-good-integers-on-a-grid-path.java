class Solution {
    long[][][][] dp;
    String s;
    int[] path;
    public long countGoodIntegersOnPath(long l, long r, String directions) {
        buildPath(directions);
        return count(r) - count(l-1);
    }
    void buildPath(String d) {
        path = new int[7];
        int r = 0, c = 0;
        path[0] = 0; 
        for (int i = 0; i < 6; i++) {
            if (d.charAt(i) == 'D') r++;
            else c++;
            path[i + 1] = r * 4 + c;
        }
    }
    long count(long x) {
        if (x < 0) return 0;
        s = String.format("%016d", x);
        dp = new long[16][2][8][10];
        for (long[][][] a : dp)
            for (long[][] b : a)
                for (long[] c : b)
                    Arrays.fill(c, -1);
        return solve(0, 1, 0, 0);
    }
    long solve(int idx,int tight,int pos,int pre){
        if(idx == 16){
            if(pos == 7) return 1;
            return 0;
        }
        if(dp[idx][tight][pos][pre]!=-1) return dp[idx][tight][pos][pre];
        int limit = tight == 1?s.charAt(idx)-'0':9;
        long ans = 0;
        for(int i = 0;i<=limit;i++){
            int nt = (tight == 1 && i == limit) ? 1 : 0;
            if(pos < 7 && path[pos] == idx){
                if(pos == 0){
                    ans+=solve(idx+1,nt,pos+1,i);
                }
                else if(i >= pre){
                    ans+=solve(idx+1,nt,pos+1,i);
                }
            }else{
                ans+=solve(idx+1,nt,pos,pre);
            }
        }
        return dp[idx][tight][pos][pre] = ans;
    }
}