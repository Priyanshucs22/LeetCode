class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int cur = 0;
        int tc = 0;
        for(int e:nums){
            cur+=e;
            if(map.containsKey(cur-goal)){
                tc+=map.get(cur-goal);
            }
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        return tc;
    }
}