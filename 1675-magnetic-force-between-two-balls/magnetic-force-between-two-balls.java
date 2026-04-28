import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int h = position[position.length - 1] - position[0];
        int ans = 0;
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if(can(mid, position, m)){
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }
    boolean can(int d, int[] pos, int m){
        int cnt = 1;
        int last = pos[0];
        for(int i = 1; i < pos.length; i++){
            if(pos[i] - last >= d){
                cnt++;
                last = pos[i];
            }
        }
        return cnt >= m;
    }
}