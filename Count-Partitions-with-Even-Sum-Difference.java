1class Solution {
2    public int countPartitions(int[] nums) {
3        int sum = 0;
4        for(int e:nums) sum+=e;
5        int a = 0;
6        int cnt = 0;
7        for(int i=0;i<nums.length-1;i++){
8            a+=nums[i];
9            sum-=nums[i];
10            if((sum-a)%2==0){
11                cnt++;
12            }
13        }
14        return cnt;
15    }
16}