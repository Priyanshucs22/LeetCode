class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int p:piles){
            r = Math.max(p,r);
        }
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(can(mid,piles,h)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    boolean can(int mid,int[] piles,int h){
        long cnt = 0;
        for(int p:piles){
            if(mid>=p){
                cnt++;
            }else{
                cnt += (long) (p + mid - 1) / mid;
            }
        }
        return cnt<=h;
    }
}