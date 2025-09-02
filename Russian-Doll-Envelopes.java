class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; 
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;
        for (int[] env : envelopes) {
            int h = env[1];
            int idx = binary(dp, 0, len-1, h);
            System.out.print(idx+" ");
            if (idx < 0) idx = -(idx + 1);
            dp[idx] = h;
            if (idx == len) len++;
        }
        return len;
    }
    public static int binary(int[] dp,int l,int r,int t){
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (dp[mid] < t) {
                l = mid + 1;   
            } else {
                r = mid - 1;   
            }
        }
        return l; 
    }
}