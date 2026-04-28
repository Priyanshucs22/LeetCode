class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int e : batteries) sum += e;
        long l = 1;
        long h = sum / n;
        long ans = 0;
        while(l <= h){
            long mid = l + (h - l) / 2;
            if(can(mid, n, batteries)){
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }
    boolean can(long mid, int n, int[] batteries){
        long total = 0;
        for(int e : batteries){
            total += Math.min(e, mid);
        }
        return total >= n * mid;
    }
}