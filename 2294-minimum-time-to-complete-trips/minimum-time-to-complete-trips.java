class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long l = 1;
        long h = (long) time[0] * totalTrips;
        long ans = 0;
        while(l<=h){
            long mid = l + (h-l)/2;
            if(can(mid,time,totalTrips)){
                ans = mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    boolean can(long mid,int[] time,int tt){
        long sum = 0;
        for(int e:time){
            sum+=(mid/e);
            if(sum >= tt) return true;
        }
        return false;
    }
}