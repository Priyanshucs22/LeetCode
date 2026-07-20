class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];
        for(int[] bk:bookings){
            int f = bk[0]-1;
            int l = bk[1]-1;
            int seat = bk[2];
            diff[f] += seat;
            diff[l+1] += -seat;
        }
        int[] ans = new int[n];
        int cur = 0;
        for(int i=0;i<n;i++){
            cur+=diff[i];
            ans[i] = cur;
        }
        return ans;
    }
}