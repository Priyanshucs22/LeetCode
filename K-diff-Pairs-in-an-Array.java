class Solution {
    public int findPairs(int[] nums, int k) {
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e:nums) map.put(e,map.getOrDefault(e,0)+1);
        for(int key:map.keySet()){
            if(k==0){
                if(map.get(key)>1) cnt++;
            }else{
                if(map.containsKey(key+k)) cnt++;
            }
        }
        return cnt;
    }
}