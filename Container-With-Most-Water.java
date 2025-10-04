class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length-1;
        while(i<=j){
            int a = Math.min(height[i],height[j]);
            max = Math.max(max,a*(j-i));
            if(height[i]>=height[j]) j--;
            else i++;
        }
        return max;
    }
}