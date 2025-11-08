class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int area = 0;
        while(l<r){
            int len = r-l;
            area = Math.max(area,len*Math.min(height[l],height[r]));
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return area;
    }
}